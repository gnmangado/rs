package net.dmslabs.re.persistence.dao.remote;

import java.util.List;

import net.dmslabs.re.domain.entities.State;

public interface StateDao extends CommonDao<State> {

    public List<State> findStates(String name, boolean onlyEnabled);
    
}
