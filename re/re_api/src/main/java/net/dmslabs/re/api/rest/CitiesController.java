package net.dmslabs.re.api.rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.dmslabs.re.domain.entities.City;
import net.dmslabs.re.persistence.dao.remote.CityDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/cities")
public class CitiesController {

    static final Logger logger = LoggerFactory.getLogger(CitiesController.class);

    private final CityDao cityDao;

    @Autowired
    public CitiesController(CityDao cityDao) {
        super();
        this.cityDao = cityDao;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody City getCity(@PathVariable(value = "id") Integer id) {
        return cityDao.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<City> getCities(@RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "onlyEnabled", required = false) Boolean onlyEnabled,
            @RequestParam(value = "stateId", required = false) Integer stateId) {
        return cityDao.findCities(name, stateId, onlyEnabled);
    }

    @RequestMapping(method = RequestMethod.POST, headers = "Content-Type=application/json")
    @ResponseStatus(HttpStatus.OK)
    public void createCity(@RequestBody City city, HttpServletResponse response) {
        cityDao.store(city);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, headers = { "Accept=application/json" })
    @ResponseStatus(HttpStatus.OK)
    public void updateCity(@PathVariable("id") Integer id, @RequestBody City city) {
        city.setId(id);
        cityDao.update(city);
    }

}
