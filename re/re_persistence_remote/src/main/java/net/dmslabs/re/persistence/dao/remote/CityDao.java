package net.dmslabs.re.persistence.dao.remote;

import java.util.List;

import net.dmslabs.re.domain.entities.City;


public interface CityDao extends CommonDao<City> {

    public List<City> findCities(String name, Integer stateId, boolean onlyEnabled);
    
}
