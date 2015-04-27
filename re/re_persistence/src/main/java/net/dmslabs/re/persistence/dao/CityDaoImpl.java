package net.dmslabs.re.persistence.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import net.dmslabs.re.persistence.dao.remote.CityDao;
import net.dmslabs.re.domain.entities.City;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

@Repository("cityDao")
public class CityDaoImpl extends AbstractCommonDaoImpl<City> implements CityDao {

    public CityDaoImpl() {
        super(City.class);
    }

    public List<City> findAll() {
        return getEntityManager().createNamedQuery("City.findAll", City.class).getResultList();
    }

    public List<City> findCities(String name, Integer stateId, Boolean onlyEnabled) {
        boolean whereAppended = false;
        boolean setName = false;
        boolean setStateId = false;

        StringBuilder jpql = new StringBuilder("SELECT c FROM City c ");

        if (!StringUtils.isEmpty(name)) {
            whereAppended = true;
            jpql.append("WHERE UPPER(c.name) LIKE :name ");
            setName = true;
        }
        if (stateId != null) {
            if (whereAppended) {
                jpql.append("AND c.state.id = :stateId ");
            } else {
                jpql.append("WHERE c.state.id = :stateId ");
            }
            whereAppended = true;
            setStateId = true;
        }
        if (onlyEnabled != null && onlyEnabled) {
            if (whereAppended) {
                jpql.append("AND c.enabled = TRUE ");
            } else {
                jpql.append("WHERE c.enabled = TRUE ");
            }
        }

        TypedQuery<City> query = getEntityManager().createQuery(jpql.toString(), City.class);
        if (setName) {
            query.setParameter("name", "%" + name.toUpperCase() + "%");
        }
        if (setStateId) {
            query.setParameter("stateId", stateId);
        }

        return query.getResultList();
    }

}
