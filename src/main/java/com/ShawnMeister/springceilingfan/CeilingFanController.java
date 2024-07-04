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
            return "<p>" + response + "</p>"; // Return HTML directly
        } catch (Exception e) {
            logger.error("Error pulling speed cord", e);
            return "<p>Error pulling speed cord!</p>";
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
        return "<p>" + response + "</p>"; // Return HTML directly
    } catch (Exception e) {
        logger.error("Error pulling direction cord", e);
        return "<p>Error pulling direction cord!</p>";
    }
}

// Catch all endpoint for invalid requests
    @GetMapping("/**")
    public String handleNotFoundError() {
        return "<h1 style='text-align: center; margin-top: 2rem;'>404 Error: Page not found!</h1>";
    }

}