package com.briup.apps.tyd.dao.extend;

import java.util.List;

import com.briup.apps.tyd.bean.extend.ArticleExtend;

public interface ArticleMapperExtend {

	List<ArticleExtend> selectAll();
	ArticleExtend selectById(long id);
}
