package com.briup.apps.tyd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.tyd.bean.Category;
import com.briup.apps.tyd.bean.CategoryExample;
import com.briup.apps.tyd.dao.CategoryMapper;
import com.briup.apps.tyd.service.ICategoryService;
import com.briup.apps.tyd.utils.CustomerException;
@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private CategoryMapper categorymapper;
	
	@Override
	public List<Category> findAll() {
		
		return categorymapper.selectByExample(new CategoryExample());
	}

	@Override
	public void saveOrUpdate(Category category) throws CustomerException {
		if (category.getId() != null) { //做更新
			categorymapper.updateByPrimaryKey(category);
		}else {
			//判断是否重名
			CategoryExample categoryExample = new CategoryExample();
			categoryExample.createCriteria().andNameEqualTo(category.getName());
			List<Category> list = categorymapper.selectByExample(categoryExample);
			if (list.size()>0) {
				throw new CustomerException("该栏目已经存在");
			}
			categorymapper.insert(category);
		}
		
	}

	@Override
	public void deletetById(long id) throws CustomerException {
		Category category = categorymapper.selectByPrimaryKey(id);
		if (category.getId() == null) {
			throw new CustomerException("要删除的栏目不存在");
		}
		categorymapper.deleteByPrimaryKey(id);
	}

	@Override
	public void batchDelete(long[] ids) throws CustomerException {
		for (long id : ids) {
			deletetById(id);
		}
	}

}
