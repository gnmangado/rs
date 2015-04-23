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

    public List<Area> findAreas(String name, Integer cityId, Integer stateId, boolean onlyEnabled) {
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
        if (cityId != null) {
            if (whereAppended) {
                jpql.append("AND a.cityId.id = :cityId ");
            } else {
                jpql.append("WHERE a.cityId.id = :cityId ");
            }
            whereAppended = true;
            setCityId = true;
        }
        if (stateId != null) {
            if (whereAppended) {
                jpql.append("AND a.cityId.stateId.id = :stateId ");
            } else {
                jpql.append("WHERE a.cityId.stateId.id = :stateId ");
            }
            whereAppended = true;
            setStateId = true;
        }
        if (onlyEnabled) {
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
            query.setParameter("cityId", cityId);
        }
        if (setStateId) {
            query.setParameter("stateId", stateId);
        }

        return query.getResultList();
    }

}
