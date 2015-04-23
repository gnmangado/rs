package net.dmslabs.re.api.rest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/countries")
public class CountryController {

    static final Logger logger = LoggerFactory.getLogger(CountryController.class);

    // @RequestMapping(value = "login", method = RequestMethod.POST, headers={"Accept=*/*", "Content-Type=application/json"})
    // public @ResponseBody
    // Map<String, String> login(@RequestBody final Globito employee) {
    // logger.info("BEGIN::login");
    // String token = null;
    // Glober glober = GlobersManager.getInstance().getGloberByAuthentication(employee.getUsername(), employee.getPassword());
    // if (glober != null) {
    // token = SessionManager.getInstance().createSession(glober);
    // } else {
    // throw new UnauthorizedException();
    // }
    // Map<String, String> response = new HashMap<String, String>();
    // response.put("session_token", token);
    // return response;
    // }

//    @RequestMapping(value = "/{name}", method = RequestMethod.GET, headers = { "Accept=application/json" })
//    public @ResponseBody
//    Country testService(@PathVariable("name") String name) {
//        logger.info("BEGIN::testService");
//        Country c = new Country();
//        c.setId(45);
//        c.setName("Uruguay");
//        return c;
//    }
}
