package net.dmslabs.re.api.rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.dmslabs.re.domain.entities.Area;
import net.dmslabs.re.persistence.dao.remote.AreaDao;

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
@RequestMapping("/areas")
public class AreasController {

    static final Logger logger = LoggerFactory.getLogger(AreasController.class);

    private final AreaDao areaDao;

    @Autowired
    public AreasController(AreaDao areaDao) {
        super();
        this.areaDao = areaDao;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Area getArea(@PathVariable(value = "id") Integer id) {
        return areaDao.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Area> getCities(@RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "onlyEnabled", required = false) Boolean onlyEnabled,
            @RequestParam(value = "cityId", required = false) Integer cityId, @RequestParam(value = "stateId", required = false) Integer stateId) {
        return areaDao.findAreas(name, cityId, stateId, onlyEnabled);
    }

    @RequestMapping(method = RequestMethod.POST, headers = "Content-Type=application/json")
    @ResponseStatus(HttpStatus.OK)
    public void createCity(@RequestBody Area area, HttpServletResponse response) {
        areaDao.store(area);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, headers = { "Accept=application/json" })
    @ResponseStatus(HttpStatus.OK)
    public void updateCity(@PathVariable("id") Integer id, @RequestBody Area area) {
        area.setId(id);
        areaDao.update(area);
    }

}
