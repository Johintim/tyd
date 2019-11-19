package com.briup.apps.tyd.dao.extend;

import java.util.List;

import com.briup.apps.tyd.bean.Role;
import com.briup.apps.tyd.bean.extend.RoleExtend;

public interface RoleExtendMapper {
	List<Role> selectByUserId(long id);
	List<RoleExtend> selectAll();
}
