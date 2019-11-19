package com.briup.apps.tyd.service;

import java.util.List;

import com.briup.apps.tyd.bean.CmsTest;

public interface ITestService {

	void saveOrUpdate(CmsTest test);

    List<CmsTest> findAll();
}
