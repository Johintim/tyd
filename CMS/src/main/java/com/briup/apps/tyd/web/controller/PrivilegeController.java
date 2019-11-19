package com.briup.apps.tyd.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.tyd.bean.Privilege;
import com.briup.apps.tyd.service.IPrivilegeService;
import com.briup.apps.tyd.utils.Message;
import com.briup.apps.tyd.utils.MessageUtil;
import com.briup.apps.tyd.vm.PrivilegeTree;

import io.swagger.annotations.ApiOperation;

/**
 * @program: cms_jd1911
 * @description: 权限控制器
 * @author: charles
 * @create: 2019-11-16 15:51
 **/
@Validated
@RestController
@RequestMapping("/privilege")
public class PrivilegeController {

    @Autowired
    private IPrivilegeService basePrivilegeService;

    @ApiOperation(value = "查询所有")
    @GetMapping(value = "findAll")
    public Message findAll(){
        List<Privilege> list = basePrivilegeService.findAll();
        return MessageUtil.success(list);
    }



    @ApiOperation(value = "通过parentId查询")
    @GetMapping(value = "findByParentId")
    public Message findByParentId(Long id){
        List<Privilege> list = basePrivilegeService.findByParentId(id);
        return MessageUtil.success(list);
    }

    @ApiOperation(value ="保存或更新")
    @PostMapping(value = "saveOrUpdate")
    public Message saveOrUpdate(Privilege privilege){
        basePrivilegeService.saveOrUpdate(privilege);
        return MessageUtil.success("更新成功");
    }

    @ApiOperation(value = "查询树")
    @GetMapping(value = "findPrivilegeTree")
    public Message findPrivilegeTree(){
        List<PrivilegeTree> list = basePrivilegeService.findPrivilegeTree();
        return MessageUtil.success(list);
    }



}
