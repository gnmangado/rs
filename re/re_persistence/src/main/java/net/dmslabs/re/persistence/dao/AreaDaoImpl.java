package net.dmslabs.re.persistence.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import net.dmslabs.re.domain.entities.Area;
import net.dmslabs.re.persistence.dao.remote.AreaDao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Repository("areaDao")
public class AreaDaoImpl extends AbstractCommonDaoImpl<Area> implements AreaDao {

    protected AreaDaoImpl() {
        super(Area.class);
    }

    @Transactional(readOnly = true)
    public List<Area> findAll() {
        return getEntityManager().createNamedQuery("Area.findAll", Area.class).getResultList();
    }

    public List<Area> findAreas(String name, Integer city, Integer state, Boolean onlyEnabled) {
        boolean whereAppended = false;
        boolean setName = false;
        boolean setCityId = false;
        boolean setStateId = false;

        StringBuilder jpql = new StringBuilder("SELECT a FROM Area a ");

        if (!StringUtils.isEmpty(name)) {
            whereAppended = true;
            jpql.append("WHERE UPPER(a.name) LIKE :name ");
            setName = true;
        }
        if (city != null) {
            if (whereAppended) {
                jpql.append("AND a.city.id = :city ");
            } else {
                jpql.append("WHERE a.city.id = :city ");
            }
            whereAppended = true;
            setCityId = true;
        }
        if (state != null) {
            if (whereAppended) {
                jpql.append("AND a.city.state.id = :state ");
            } else {
                jpql.append("WHERE a.city.state.id = :state ");
            }
            whereAppended = true;
            setStateId = true;
        }
        if (onlyEnabled != null && onlyEnabled) {
            if (whereAppended) {
                jpql.append("AND a.enabled = TRUE ");
            } else {
                jpql.append("WHERE a.enabled = TRUE ");
            }
        }

        TypedQuery<Area> query = getEntityManager().createQuery(jpql.toString(), Area.class);
        if (setName) {
            query.setParameter("name", "%" + name.toUpperCase() + "%");
        }
        if (setCityId) {
            query.setParameter("city", city);
        }
        if (setStateId) {
            query.setParameter("state", state);
        }

        return query.getResultList();
    }

}
