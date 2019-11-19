package com.briup.apps.tyd.service.impl;

import org.springframework.stereotype.Service;

import com.briup.apps.tyd.bean.CmsTest;
import com.briup.apps.tyd.bean.CmsTestExample;
import com.briup.apps.tyd.dao.CmsTestMapper;
import com.briup.apps.tyd.service.ITestService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: cms_jd1911
 * @description: 测试业务类
 * @author: charles
 * @create: 2019-11-11 12:22
 **/
@Service
public class TestServiceImpl implements ITestService {
	@Resource
    private CmsTestMapper testMapper;
	
	@Override
	public void saveOrUpdate(CmsTest test) {
		if(test.getId()!=null){
            testMapper.updateByPrimaryKey(test);
        } else {
            testMapper.insert(test);
        }
	}

	@Override
	public List<CmsTest> findAll() {
		CmsTestExample example = new CmsTestExample();
        return testMapper.selectByExample(example);
	}

    
}
