package com.shawnmeister.springceilingfan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    private static final Logger logger = LoggerFactory.getLogger(WebController.class);
    private final CeilingFan ceilingFan;

    public WebController(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }
    // index endpoint
    @GetMapping("/")
    public String index() {
        try {
            return "index";
        } catch (Exception e) {
            logger.error("Error getting index.html", e);
            return "Error getting index.html";
        }
    }

    // recipe endpoint
    @GetMapping("/api/recipe")
    public String recipe() {
        try {
            ceilingFan.getRecipe();
            return "recipe";
        } catch (Exception e) {
            logger.error("Error getting recipe", e);
            return "Error getting recipe!";
        }
    }

    // Catch all endpoint for invalid requests
    @GetMapping("/**")
    public String handleNotFoundError() {
        try {
            return "404";
        } catch (Exception e) {
            logger.error("Error getting 404.html", e);
            return "Error getting 404.html";
        }
    }
}
