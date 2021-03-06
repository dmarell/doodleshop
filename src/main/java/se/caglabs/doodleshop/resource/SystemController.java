/*
 * Created by Daniel Marell 14-03-02 12:02
 */
package se.caglabs.doodleshop.resource;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import se.caglabs.doodleshop.util.BuildInfo;
import se.caglabs.doodleshop.util.RunEnvironment;

@RestController
public class SystemController {
    @Autowired
    private Environment environment;

    @Autowired
    private Flyway flyway;

    @RequestMapping(value = "/appversion", method = RequestMethod.GET)
    public String getAppVersion() {
        return BuildInfo.getAppVersion();
    }

    @RequestMapping(value = "/runenvironment", method = RequestMethod.GET)
    public String getRunEnvironment() {
        return RunEnvironment.getCurrentEnvironment(environment).toString();
    }

    @RequestMapping(value = "/dbversion", method = RequestMethod.GET)
    public String getDbVersion() {
        return flyway.info().current().getVersion().toString();
    }
}