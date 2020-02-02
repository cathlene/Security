package springsecurity.demo.dao;

import springsecurity.demo.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
