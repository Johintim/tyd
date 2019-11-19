package com.briup.apps.tyd.dao.extend;

import java.util.List;

import com.briup.apps.tyd.bean.extend.UserExtend;

public interface UserExtendMapper {
	UserExtend selectById(long id);
	List<UserExtend> selectAll();
}
