package pl.put.poznan.scenario.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.put.poznan.scenario.logic.JSONfileReader;


@SpringBootApplication(scanBasePackages = {"pl.put.poznan.scenario.rest"})
public class ScenarioQualityCheckerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScenarioQualityCheckerApplication.class, args);
        System.out.println("\n-----> Scenario Quality Checker <-----\n");
        String JSONfile = new JSONfileReader().toString("vehicle_inspection_station_scenario.json");
        System.out.println(JSONfile);
    }

}