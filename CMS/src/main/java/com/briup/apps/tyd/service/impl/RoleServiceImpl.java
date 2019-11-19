package com.briup.apps.tyd.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.tyd.bean.CmsRolePrivilege;
import com.briup.apps.tyd.bean.CmsRolePrivilegeExample;
import com.briup.apps.tyd.bean.Role;
import com.briup.apps.tyd.bean.RoleExample;
import com.briup.apps.tyd.bean.extend.RoleExtend;
import com.briup.apps.tyd.dao.CmsRolePrivilegeMapper;
import com.briup.apps.tyd.dao.RoleMapper;
import com.briup.apps.tyd.dao.extend.RoleExtendMapper;
import com.briup.apps.tyd.service.IRoleService;
import com.briup.apps.tyd.utils.CustomerException;
@Service
public class RoleServiceImpl implements IRoleService{

	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private RoleExtendMapper roleExtendMapper;
	@Autowired
	private CmsRolePrivilegeMapper cmsRolePrivilegeMapper;
	
	@Override
	public void authorization(long roleId, List<Long> privilegeIds) {
		// 根据roleid查询出所有的权限
		CmsRolePrivilegeExample example = new CmsRolePrivilegeExample();
		example.createCriteria().andRoleIdEqualTo(roleId);
		List<CmsRolePrivilege> list = cmsRolePrivilegeMapper.selectByExample(example);
		// 将list转换为privilegeIDs的集合
		List<Long> old_privilegeIds = new ArrayList<>();
		for(CmsRolePrivilege rp: list) {
			old_privilegeIds.add(rp.getPrivilegeId());
		}
		// 依次判断privilegeIds 是否存在old_privilegeIds，如果不在则插入
		for (Long privilegeId : privilegeIds) {
			if (!old_privilegeIds.contains(privilegeId)) {
				CmsRolePrivilege rp = new CmsRolePrivilege();
				rp.setRoleId(roleId);
				rp.setPrivilegeId(privilegeId);
				cmsRolePrivilegeMapper.insert(rp);
			}
		}
		// 依次判断 是否存在old_privilegeIds 是否存在privilegeIds，如果不存在删除
		for (Long privilegeId : old_privilegeIds) {
			if (!privilegeIds.contains(privilegeId)) {
				// 根据privilegeId 从桥表中删除
				example.clear();
				example.createCriteria().andRoleIdEqualTo(roleId).andPrivilegeIdEqualTo(privilegeId);
				cmsRolePrivilegeMapper.deleteByExample(example);
			}
		}
	}

	@Override
	public List<Role> findAll() {
		return roleMapper.selectByExample(new RoleExample());
	}

	@Override
	public List<RoleExtend> cascadePrivilegeFindAll() {
		return roleExtendMapper.selectAll();
	}

	@Override
	public void saveOrUpdate(Role baseRole) throws CustomerException {
		if (baseRole.getId()!=null) {
			roleMapper.updateByPrimaryKey(baseRole);
		}else {
			roleMapper.insert(baseRole);
		}
	}

	@Override
	public void deleteById(long id) throws CustomerException {
		Role role = roleMapper.selectByPrimaryKey(id);
		if (role == null) {
			throw new CustomerException("要删除的角色不存在");
		}
		roleMapper.deleteByPrimaryKey(id);
	}

}
