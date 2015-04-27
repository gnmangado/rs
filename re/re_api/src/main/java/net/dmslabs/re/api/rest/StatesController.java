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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody State getState(@PathVariable(value = "id") Integer id) {
        return stateDao.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<State> getStates(@RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "onlyEnabled", required = false) Boolean onlyEnabled) {
        return stateDao.findStates(name, onlyEnabled == null ? false : onlyEnabled);
    }

    @RequestMapping(method = RequestMethod.POST, headers = "Content-Type=application/json")
    @ResponseStatus(HttpStatus.OK)
    public void createState(@RequestBody State state, HttpServletResponse response) {
        stateDao.store(state);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, headers = { "Accept=application/json" })
    @ResponseStatus(HttpStatus.OK)
    public void updateState(@PathVariable("id") Integer id, @RequestBody State state, HttpServletResponse response) {
        state.setId(id);
        stateDao.update(state);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteState(@PathVariable("id") Integer id) {
        stateDao.remove(id);
    }
}
