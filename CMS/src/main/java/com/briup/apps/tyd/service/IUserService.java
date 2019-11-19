package com.briup.apps.tyd.service;

import java.util.List;

import com.briup.apps.tyd.bean.User;
import com.briup.apps.tyd.bean.extend.UserExtend;
import com.briup.apps.tyd.utils.CustomerException;
import com.briup.apps.tyd.vm.UserVM;

public interface IUserService {
	 /** 
     * @Description: 登录
     * @Param: [userVM] 
     * @return: void 
     * @Author: charles 
     * @Date: 2019-11-18 
     */
    User login(UserVM userVM) throws CustomerException;
    
	UserExtend findById(long id);
	/**
     * @Description: 查询所有
     * @Param: []
     * @return: java.util.List<com.briup.apps.cms.bean.BaseUser>
     * @Author: charles
     * @Date: 2019-11-16
     */
    List<User> findAll();
    
    /** 
     * @Description: 级联查询所有
     * @Param: [] 
     * @return: java.util.List<com.briup.apps.cms.bean.extend.BaseUserExtend> 
     * @Author: charles 
     * @Date: 2019-11-17 
     */ 
    List<UserExtend> cascadeRoleFindAll();

    /**
     * @Description:  保存或更新
     * @Param: [baseUser]
     * @return: void
     * @Author: charles
     * @Date: 2019-11-16
     */
    void saveOrUpdate(User baseUser) throws CustomerException;

    /** 
     * @Description: 更新状态
     * @Param: [status] 
     * @return: void 
     * @Author: charles 
     * @Date: 2019-11-16 
     */ 
    void changeStatus(long id,String status) throws CustomerException;
    
    /** 
     * @Description: 通过id删除
     * @Param: [id] 
     * @return: void 
     * @Author: charles 
     * @Date: 2019-11-17
     */ 
    void deleteById(long id) throws CustomerException;
    
    /** 
     * @Description: 设置角色
     * @Param: [id, roles] 
     * @return: void 
     * @Author: charles 
     * @Date: 2019-11-17 
     */ 
    void setRoles(long id, List<Long> roles);
}
