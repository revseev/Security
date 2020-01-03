package spring.dao;

import spring.model.Role;

import java.util.List;

public interface RoleDao {

    void addRole(Role role);

    Role getRole(long id);

    List<Role> getAllRoles();

    void deleteRole(long id);
}
