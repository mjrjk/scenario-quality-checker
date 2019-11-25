package pl.put.poznan.scenario.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScenarioQualityCheckerController {
        @RequestMapping(method = RequestMethod.GET, path = "/hello")
        public String satHello() {
            return "Hello world";
        }
}
