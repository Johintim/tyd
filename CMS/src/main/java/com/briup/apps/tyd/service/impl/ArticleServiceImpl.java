package com.briup.apps.tyd.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.tyd.bean.Article;
import com.briup.apps.tyd.bean.ArticleExample;
import com.briup.apps.tyd.bean.extend.ArticleExtend;
import com.briup.apps.tyd.dao.ArticleMapper;
import com.briup.apps.tyd.dao.extend.ArticleMapperExtend;
import com.briup.apps.tyd.service.IArticleService;
import com.briup.apps.tyd.utils.CustomerException;
@Service
public class ArticleServiceImpl implements IArticleService {
	@Autowired
	private ArticleMapper articleMapper;
	@Autowired
	private ArticleMapperExtend articleMapperExtend;
	
	@Override
	public List<Article> findAll() {
		return articleMapper.selectByExample(new ArticleExample());
	}

	@Override
	public List<ArticleExtend> cascadeFindAll() {
		return articleMapperExtend.selectAll();
	}

	@Override
	public ArticleExtend findById(long id) {
		ArticleExtend articleExtend = articleMapperExtend.selectById(id);
		return articleExtend;
	}
	
	@Override
	public void saveOrUpdate(Article article) throws CustomerException {
		if(article.getId()!=null){
            articleMapper.updateByPrimaryKey(article);
        } else {
            // 标题不能重名
            ArticleExample example = new ArticleExample();
            example.createCriteria().andTitleEqualTo(article.getTitle());

            List<Article> articles = articleMapper.selectByExample(example);
            if(articles.size()>0){
                throw new CustomerException("标题不能重复");
            }
            // 初始化
            article.setPublishTime(new Date().getTime());
            article.setStatus(ArticleExtend.STATUS_UNCHECK);
            article.setThumpDown(0l);
            article.setThumpUp(0l);
            articleMapper.insert(article);
        }
	}

	@Override
	public void deleteById(long id) throws CustomerException {
		ArticleExtend articleExtend = findById(id);
		if (articleExtend.getId() == null) {
			throw new CustomerException("要删除的文章不存在");
		}
		articleMapper.deleteByPrimaryKey(id);
	}

	

}
