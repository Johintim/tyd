package com.briup.apps.tyd.web.controller;

import com.briup.apps.tyd.bean.User;
import com.briup.apps.tyd.bean.extend.UserExtend;
import com.briup.apps.tyd.service.IUserService;
import com.briup.apps.tyd.utils.Message;
import com.briup.apps.tyd.utils.MessageUtil;
import com.briup.apps.tyd.vm.UserRoleVM;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @program: cms_jd1911
 * @description: 用户基础控制器类
 * @author: charles
 * @create: 2019-11-16 16:23
 **/
@Validated
@RestController
@RequestMapping("/baseUser")
public class BaseUserController {
    @Autowired
    private IUserService baseUserService;

    @ApiOperation(value = "查询所有")
    @GetMapping(value = "findAll")
    public Message findAll(){
        List<User> list = baseUserService.findAll();
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "查询所有",notes = "级联用户角色")
    @GetMapping(value = "cascadeRoleFindAll")
    public Message cascadeRoleFindAll(){
        List<UserExtend> list = baseUserService.cascadeRoleFindAll();
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "保存或更新")
    @PostMapping(value = "saveOrUpdate")
    public Message saveOrUpdate(User baseUser){
        baseUserService.saveOrUpdate(baseUser);
        return MessageUtil.success("更新成功");
    }

    @ApiOperation(value = "通过id删除")
    @GetMapping(value = "deleteById")
    public Message deleteById(long id){
        baseUserService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @ApiOperation(value = "设置权限")
    @PostMapping(value = "setRoles")
    public Message setRoles(UserRoleVM userRoleVM){
        System.out.println(userRoleVM);
        baseUserService.setRoles(userRoleVM.getId(),userRoleVM.getRoles());
        return MessageUtil.success("设置成功");
    }


}
