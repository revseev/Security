package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.dao.RoleDao;
import spring.model.Role;

import java.util.List;

@Service
@Transactional
        (readOnly = true) //TODO is it really needed?
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Override
    public Role getById(long id) {
        return roleDao.getById(id);
    }

    @Override
    public Role getByType(String type) {
        return roleDao.getByType(type);
    }

    @Override
    public List<Role> getAll() {
        return roleDao.getAll();
    }
}
