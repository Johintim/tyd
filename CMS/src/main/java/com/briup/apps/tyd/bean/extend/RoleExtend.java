package com.briup.apps.tyd.bean.extend;

import java.util.List;

import com.briup.apps.tyd.bean.Privilege;
import com.briup.apps.tyd.bean.Role;

/**
 * 角色扩展类
 * @author 远东
 *
 */
public class RoleExtend extends Role {
	private List<Privilege> privileges;

	public List<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}
	
}
