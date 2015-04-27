package net.dmslabs.re.persistence.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import net.dmslabs.re.persistence.dao.remote.StateDao;
import net.dmslabs.re.domain.entities.State;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

@Repository("stateDao")
public class StateDaoImpl extends AbstractCommonDaoImpl<State> implements StateDao {

    public StateDaoImpl() {
        super(State.class);
    }

    public List<State> findAll() {
        return getEntityManager().createNamedQuery("State.findAll", State.class).getResultList();
    }

    public List<State> findStates(String name, boolean onlyEnabled) {
        boolean whereAppended = false;
        boolean setName = false;

        StringBuilder jpql = new StringBuilder("SELECT s FROM State s ");

        if (!StringUtils.isEmpty(name)) {
            whereAppended = true;
            jpql.append("WHERE UPPER(s.name) LIKE :name ");
            setName = true;
        }
        if (onlyEnabled) {
            if (whereAppended) {
                jpql.append("AND s.enabled = TRUE ");
            } else {
                jpql.append("WHERE s.enabled = TRUE ");
            }
        }

        TypedQuery<State> query = getEntityManager().createQuery(jpql.toString(), State.class);
        if (setName) {
            query.setParameter("name", "%" + name.toUpperCase() + "%");
        }
        
        return query.getResultList();
    }

}
