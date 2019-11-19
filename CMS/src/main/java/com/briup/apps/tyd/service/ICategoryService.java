package com.briup.apps.tyd.service;

import java.util.List;

import com.briup.apps.tyd.bean.Article;
import com.briup.apps.tyd.bean.Category;
import com.briup.apps.tyd.bean.extend.ArticleExtend;
import com.briup.apps.tyd.utils.CustomerException;

public interface ICategoryService {

	List<Category> findAll();
	void saveOrUpdate(Category Category) throws CustomerException;
	void deletetById(long id) throws CustomerException;
	void batchDelete(long[] ids) throws CustomerException; 
}
