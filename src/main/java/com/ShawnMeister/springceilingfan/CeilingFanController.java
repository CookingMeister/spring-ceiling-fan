package com.shawnmeister.springceilingfan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CeilingFanController {

    private static final Logger logger = LoggerFactory.getLogger(CeilingFanController.class);

    private final CeilingFan ceilingFan;

    public CeilingFanController(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    // pull-speed-cord endpoint
    @GetMapping("/api/pull-speed-cord")
    public String pullSpeedCord() {
        try {
            ceilingFan.pullSpeedCord();
            String response = String.format("Speed cord pulled! Current speed: %d", ceilingFan.getSpeed());
            logger.info(response); // This will log to the console
            return response;
        } catch (Exception e) {
            logger.error("Error pulling speed cord", e);
            return "Error pulling speed cord!";
        }
    }

    // pull-direction-cord endpoint
    @GetMapping("/api/pull-direction-cord")
    public String pullDirectionCord() {
        try {
            ceilingFan.pullDirectionCord();
            String direction = ceilingFan.isReversed() ? "reverse" : "forward";
            String response = String.format("Direction cord pulled! Current direction: %s", direction);
            logger.info(response); // This will log to the console
            return response;
        } catch (Exception e) {
            logger.error("Error pulling direction cord", e);
            return "Error pulling direction cord!";
        }
    }

}