package spring.dao;

import spring.model.Role;

import java.util.List;

public interface RoleDao {

    Role getById(long id);

    List<Role> getAll();

    Role getByType(String type);

}
