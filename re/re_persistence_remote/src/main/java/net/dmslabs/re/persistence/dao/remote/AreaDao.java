package net.dmslabs.re.persistence.dao.remote;

import java.util.List;

import net.dmslabs.re.domain.entities.Area;

public interface AreaDao extends CommonDao<Area> {

    public List<Area> findAreas(String name, Integer cityId, Integer stateId, Boolean onlyEnabled);

}
