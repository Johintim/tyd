package com.briup.apps.tyd.service;

import java.util.List;

import com.briup.apps.tyd.bean.Role;
import com.briup.apps.tyd.bean.extend.RoleExtend;
import com.briup.apps.tyd.utils.CustomerException;

public interface IRoleService {

	/** 
     * @Description: 授权 
     * @Param: [roleId, privilegeIds] 
     * @return: void 
     * @Author: charles 
     * @Date: 2019-11-18 
     */ 
    void authorization(long roleId,List<Long> privilegeIds);
    
    /** 
     * @Description: 查询所有角色 
     * @Param: [] 
     * @return: java.util.List<com.briup.apps.cms.bean.BaseRole> 
     * @Author: charles 
     * @Date: 2019-11-16 
     */ 
    List<Role> findAll();
    
    /** 
     * @Description: 查询角色级联权限
     * @Param: [] 
     * @return: java.util.List<com.briup.apps.cms.bean.extend.BaseRoleExtend> 
     * @Author: charles 
     * @Date: 2019-11-17 
     */ 
    List<RoleExtend> cascadePrivilegeFindAll();
    
    /** 
     * @Description: 保存或更新角色信息 
     * @Param: [baseRole] 
     * @return: void 
     * @Author: charles 
     * @Date: 2019-11-16 
     */ 
    void saveOrUpdate(Role baseRole) throws CustomerException;
    
    /** 
     * @Description: 通过id删除角色信息 
     * @Param: [id] 
     * @return: void 
     * @Author: charles 
     * @Date: 2019-11-16 
     */ 
    void deleteById(long id) throws CustomerException;
}
