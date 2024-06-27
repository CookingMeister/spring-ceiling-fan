package com.shawnmeister.springceilingfan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> pullSpeedCord() {
        try {
            ceilingFan.pullSpeedCord();
            String response = String.format("Speed cord pulled! Current speed: %d", ceilingFan.getSpeed());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Error pulling speed cord", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error pulling speed cord!");
        }
    }

// pull-direction-cord endpoint
    @GetMapping("/api/pull-direction-cord")
    public ResponseEntity<String> pullDirectionCord() {
        try {
            ceilingFan.pullDirectionCord();
            String direction = ceilingFan.isReversed() ? "reverse" : "forward";
            String response = String.format("Direction cord pulled! Current direction: %s", direction);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Error pulling direction cord", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error pulling direction cord!");
        }
    }

// recipe endpoint
    // @GetMapping("/recipe")
    // public String getRecipe() {
    //     try {
    //         ceilingFan.getRecipe();
    //         return "<html>"
    //                 + "<head>"
    //                 + "<title>Secret Recipe</title>"
    //                 + "</head>"
    //                 + "<body>"
    //                 + "<h1>Cream Cheese Blondies Recipe</h1>"
    //                 + "<h3>Ingredients: </h3>"
    //                 + "<ul>"
    //                 + "<li>1/2 cup butter</li>"
    //                 + "<li>1/2 cup white sugar</li>"
    //                 + "<li>1/2 cup brown sugar</li>"
    //                 + "<li>2 eggs</li>"
    //                 + "<li>1 teaspoon vanilla</li>"
    //                 + "<li>1/2 teaspoon salt</li>"
    //                 + "<li>2 teaspoons baking powder</li>"
    //                 + "<li>1/4 teaspoon baking soda</li>"
    //                 + "<li>1 cup flour</li>"
    //                 + "<li>1 cup milk</li>"
    //                 + "<li>1 cup cream cheese</li>"
    //                 + "<li>1/2 cup chocolate chips</li>"
    //                 + "<li>1/4 cup chopped walnuts</li>"
    //                 + "</ul>"
    //                 + "<h3>Method: </h3>"
    //                 + "<ol>"
    //                 + "<li>Preheat oven to 350 degrees F (175 degrees C).</li>"
    //                 + "<li>In a large bowl, cream together the butter, white sugar, brown sugar, eggs, and vanilla.</li>"
    //                 + "<li>Add the baking powder, salt, baking soda, and sifted flour. Mix well.</li>"
    //                 + "<li>In a separate bowl, whisk together the milk, cream cheese, and chocolate chips.</li>"
    //                 + "<li>Stir the walnuts into the cream cheese mixture.</li>"
    //                 + "<li>Add all ingredients to one bowl and fold to combine</li>"
    //                 + "<li>Pour the batter into a 9x9 inch pan. Bake for 35 to 40 minutes or until the top is golden brown and a toothpick inserted comes out clean.</li>"
    //                 + "</ol>"
    //                 + "</body>"
    //                 + "</html>";
    //     } catch (Exception e) {
    //         logger.error("Error getting recipe", e);
    //         return "Error getting recipe!";
    //     }
    // }

// Catch all endpoint for invalid requests
    @GetMapping("/**")
    public String handleNotFoundError() {
        return "<h1 style='text-align: center; margin-top: 2rem;'>404 Error: Page not found!</h1>";
    }

}