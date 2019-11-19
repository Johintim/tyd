package com.briup.apps.tyd.dao.extend;

import com.briup.apps.tyd.bean.Privilege;
import com.briup.apps.tyd.vm.PrivilegeTree;

import java.util.List;

public interface PrivilegeExtendMapper {
    List<PrivilegeTree> selectAll();

    List<Privilege> selectByParentId(long id);

    List<Privilege> selectByRoleId(long id);
    List<Privilege> selectByUserId(long id);
}
