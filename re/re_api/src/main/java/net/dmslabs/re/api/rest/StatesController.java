package net.dmslabs.re.api.rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.dmslabs.re.domain.entities.State;
import net.dmslabs.re.persistence.dao.remote.StateDao;

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
@RequestMapping("/states")
public class StatesController {

    static final Logger logger = LoggerFactory.getLogger(StatesController.class);

    private final StateDao stateDao;

    @Autowired
    public StatesController(StateDao stateDao) {
        super();
        this.stateDao = stateDao;
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET, headers = { "Accept=application/json" })
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    State testService(@PathVariable("name") String name) {
        logger.info("BEGIN::testService");
        State c = new State();
        c.setName(name);
        // c = stateDao.store(c);
        return c;
    }

    @RequestMapping(method = RequestMethod.POST, headers = "Content-Type=application/json")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    State createState(@RequestBody State state, HttpServletResponse response) {
        State s = stateDao.store(state);
        response.setHeader("Location", "/states/caca");
        return s;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, headers = { "Accept=application/json" })
    @ResponseStatus(HttpStatus.OK)
    public void putState(@PathVariable("id") int id, @RequestBody State state) {
        stateDao.update(state);
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<State> getStates(@RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "onlyEnabled", required = false) Boolean onlyEnabled) {
        logger.info("BEGIN::testService");
        return stateDao.findStates(name, onlyEnabled == null ? false : onlyEnabled);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public void deleteSpittle(@PathVariable("id") long id) {
 
    }
}
