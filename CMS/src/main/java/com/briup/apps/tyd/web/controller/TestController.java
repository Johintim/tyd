package com.briup.apps.tyd.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.tyd.bean.CmsTest;
import com.briup.apps.tyd.service.ITestService;
import com.briup.apps.tyd.utils.Message;
import com.briup.apps.tyd.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/test")
@Api(value = "SayController|一个用来测试swagger注解的控制器")
public class TestController {
	@Autowired
	private ITestService TestServiceImpl;

	@GetMapping("findAll")
	@ApiOperation(value="这是一个查询所有的测试方法", notes="test: 不需要传递任何值")
	public Message test() {
		List<CmsTest> list = TestServiceImpl.findAll();
		return MessageUtil.success(list);
	}

	@PostMapping(value = "saveOrUpdate")
	public String saveOrUpdate(CmsTest test) {
		// 调用service,完成保存
		TestServiceImpl.saveOrUpdate(test);
		return "保存成功";
	}
}
