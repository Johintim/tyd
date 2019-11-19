package com.briup.apps.tyd.service;

import java.util.List;

import com.briup.apps.tyd.bean.Privilege;
import com.briup.apps.tyd.utils.CustomerException;
import com.briup.apps.tyd.vm.PrivilegeTree;

public interface IPrivilegeService {
	 /** 
     * @Description: 查询所有权限 
     * @Param: [] 
     * @return: java.util.List<com.briup.apps.cms.bean.BasePrivilege> 
     * @Author: charles 
     * @Date: 2019-11-16 
     */ 
    List<Privilege> findAll();
    
    /** 
     * @Description: 通过parentId查询权限
     * @Param: [parentId] 
     * @return: java.util.List<com.briup.apps.cms.bean.BasePrivilege> 
     * @Author: charles 
     * @Date: 2019-11-17 
     */ 
    List<Privilege> findByParentId(Long parentId);
    
    /** 
     * @Description: 保存或更新权限 
     * @Param: [privilege] 
     * @return: void 
     * @Author: charles 
     * @Date: 2019-11-16 
     */ 
    void saveOrUpdate(Privilege privilege) throws CustomerException;

    List<PrivilegeTree> findPrivilegeTree();
    
    /** 
     * @Description: 查询用户所有权限 
     * @Param: [id] 
     * @return: java.util.List<com.briup.apps.cms.bean.BasePrivilege> 
     * @Author: charles 
     * @Date: 2019-11-18 
     */ 
    List<Privilege> findByUserId(long id);
}
