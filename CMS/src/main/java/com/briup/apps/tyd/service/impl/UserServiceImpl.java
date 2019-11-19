package com.briup.apps.tyd.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.tyd.bean.CmsUserRole;
import com.briup.apps.tyd.bean.CmsUserRoleExample;
import com.briup.apps.tyd.bean.User;
import com.briup.apps.tyd.bean.UserExample;
import com.briup.apps.tyd.bean.extend.UserExtend;
import com.briup.apps.tyd.dao.CmsUserRoleMapper;
import com.briup.apps.tyd.dao.UserMapper;
import com.briup.apps.tyd.dao.extend.UserExtendMapper;
import com.briup.apps.tyd.service.IUserService;
import com.briup.apps.tyd.utils.CustomerException;
import com.briup.apps.tyd.vm.UserVM;
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserExtendMapper userExtendMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private CmsUserRoleMapper cmsUserRoleMapper;
	
	@Override
	public User login(UserVM userVM) throws CustomerException {
		UserExample example = new UserExample();
		example.createCriteria().andUsernameEqualTo(userVM.getUsername());
		List<User> list = userMapper.selectByExample(example);
		if (list.size()<=0) {
			throw new CustomerException("该用户不存在");
		}
		User user = list.get(0);
		//System.out.println(user);
//		System.out.println(user.getPassword());
		//用户必须有密码，不然会报空指针
		if (!user.getPassword().equals(userVM.getPassword())) {
			throw new CustomerException("密码不匹配");
		}
		return user;
	}
	
	@Override
	public UserExtend findById(long id) {
		
		return userExtendMapper.selectById(id);
	}

	@Override
	public List<User> findAll() {
		return userMapper.selectByExample(new UserExample());
	}

	@Override
	public List<UserExtend> cascadeRoleFindAll() {
		return userExtendMapper.selectAll();
	}

	@Override
	public void saveOrUpdate(User baseUser) throws CustomerException {
		if (baseUser.getId()!=null) {
			userMapper.updateByPrimaryKey(baseUser);
		}else {
			// 判断用户名是否被占用
			UserExample example = new UserExample();
			example.createCriteria().andUsernameEqualTo(baseUser.getUsername());
			List<User> list = userMapper.selectByExample(example);
			if (list.size()>0) {
				throw new CustomerException("该用户已经被占用");
			}
			// 初始化
			baseUser.setRegisterTime(new Date().getTime());
            baseUser.setStatus(UserExtend.STATUS_NORMAL);
			userMapper.insert(baseUser);
		}
		
	}

	@Override
	public void changeStatus(long id, String status) throws CustomerException {
		UserExtend uExtend = findById(id);
		if (uExtend==null) {
			throw new CustomerException("该用户不存在");
		}
		uExtend.setStatus(status);
		userMapper.updateByPrimaryKey(uExtend);

	}

	@Override
	public void deleteById(long id) throws CustomerException {
		UserExtend uExtend = findById(id);
		if (uExtend==null) {
			throw new CustomerException("该用户不存在");
		}
		userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void setRoles(long id, List<Long> roles) {
		// 根据userid查询自己的角色
		CmsUserRoleExample example = new CmsUserRoleExample();
		example.createCriteria().andUserIdEqualTo(id);
		// 用户角色关系,获取所有老的角色
		List<CmsUserRole> list = cmsUserRoleMapper.selectByExample(example);
		List<Long> oldRoles = new ArrayList<Long>();
		Iterator<CmsUserRole> iterator = list.iterator();
		while(iterator.hasNext()) {
			CmsUserRole uRole = iterator.next();
			oldRoles.add(uRole.getRoleId());
		}
		// [1,2,3] -> [3,4] 添加1,2 => [1,2,3,4]
		// 依次判断新角色是否存在于list中，如果不存在则添加
		for (Long roleId : roles) {
			if (!oldRoles.contains(roleId)) {
				CmsUserRole userRole = new CmsUserRole();
				userRole.setUserId(id);
				userRole.setRoleId(roleId);
				cmsUserRoleMapper.insert(userRole);
			}
		}
		// [1,2,3] -> [1,2,3,4]   删除 3,4  => [1,2]
        // 依次判断老的角色是否存在于roles中，如果不存在则删除
		for (Long roleId : oldRoles) {
			if (!roles.contains(roleId)) {
				cmsUserRoleMapper.deleteByPrimaryKey(roleId);
			}
		}
		
	}

	

}
