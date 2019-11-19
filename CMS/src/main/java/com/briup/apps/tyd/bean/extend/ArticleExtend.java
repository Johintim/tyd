package com.briup.apps.tyd.bean.extend;

import java.util.List;

import com.briup.apps.tyd.bean.Article;
import com.briup.apps.tyd.bean.Category;
import com.briup.apps.tyd.bean.Comment;

public class ArticleExtend extends Article{
	public static final String STATUS_UNCHECK="未审核";
    public static final String STATUS_CHECK_PASS="审核通过";
    public static final String STATUS_CHECK_NOPASS="审核未通过";
    private List<Comment> comments;
	private Category category;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
