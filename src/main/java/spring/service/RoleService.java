package spring.service;

import spring.model.Role;

import java.util.List;

public interface RoleService {

    Role getById(long id);

    Role getByType(String type);

    List<Role> getAll();
}
