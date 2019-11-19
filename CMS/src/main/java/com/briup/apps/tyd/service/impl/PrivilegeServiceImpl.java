package com.briup.apps.tyd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.tyd.bean.Privilege;
import com.briup.apps.tyd.bean.PrivilegeExample;
import com.briup.apps.tyd.dao.PrivilegeMapper;
import com.briup.apps.tyd.dao.extend.PrivilegeExtendMapper;
import com.briup.apps.tyd.service.IPrivilegeService;
import com.briup.apps.tyd.utils.CustomerException;
import com.briup.apps.tyd.vm.PrivilegeTree;
/**
 *     权限控制实现类
 * @author 远东
 *
 */
@Service
public class PrivilegeServiceImpl implements IPrivilegeService {

	@Autowired
	private PrivilegeMapper privilegeMapper;
	@Autowired
	private PrivilegeExtendMapper privilegeExtendMapper;
	
	@Override
	public List<Privilege> findByUserId(long id) {
		return privilegeExtendMapper.selectByUserId(id);
	}
	
	@Override
	public List<Privilege> findAll() {
		return privilegeMapper.selectByExample(new PrivilegeExample());
	}

	@Override
	public List<Privilege> findByParentId(Long parentId) {
		PrivilegeExample pExample = new PrivilegeExample();
		if(parentId == null){
			pExample.createCriteria().andParentIdIsNull();
        } else {
        	pExample.createCriteria().andParentIdEqualTo(parentId);
        }
		return privilegeMapper.selectByExample(pExample);
	}

	@Override
	public void saveOrUpdate(Privilege privilege) throws CustomerException {
		if (privilege.getId()!=null) {
			//这是一个更新操作
			privilegeMapper.updateByPrimaryKey(privilege);
		}else {
			privilegeMapper.insert(privilege);
		}
	}

	@Override
	public List<PrivilegeTree> findPrivilegeTree() {
		return privilegeExtendMapper.selectAll();
	}

	

}
