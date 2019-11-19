package com.briup.apps.tyd.dao.extend;

import com.briup.apps.tyd.bean.Comment;

import java.util.List;

public interface CommentExtendMapper {

    List<Comment> selectByArticleId(long article_id);
}
