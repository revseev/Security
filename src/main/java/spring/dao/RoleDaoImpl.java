package spring.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.model.Role;

import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }


    public Role getById(long id) {
        return getCurrentSession().get(Role.class, id);
    }

    public Role getByType(String type) {
        Criteria crit = getCurrentSession().createCriteria(Role.class);
        crit.add(Restrictions.eq("type", type));
        return (Role) crit.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<Role> getAll(){
        Criteria crit = getCurrentSession().createCriteria(Role.class);
        crit.addOrder(Order.asc("type"));
        return (List<Role>)crit.list();
    }
}
