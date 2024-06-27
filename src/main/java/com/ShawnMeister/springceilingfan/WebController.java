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

    @GetMapping("/")
    public String index() {
        try {
            return "index";
        } catch (Exception e) {
            logger.error("Error getting index.html", e);
            return "Error getting index.html";
        }
    }

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
}
