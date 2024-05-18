package com.ShawnMeister.springceilingfan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringCeilingFanApplication {
	private CeilingFan ceilingFan;

	public SpringCeilingFanApplication() {
		ceilingFan = new CeilingFan();
		// KeyEventHandler keyEventHandler = new KeyEventHandler(ceilingFan);
		// keyEventHandler.createKeyListener();
	}

	public static void main(String[] args) {
		try {
			SpringApplication.run(SpringCeilingFanApplication.class, args);
			System.out.println("Hello, I am a big fan");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/")
	public String index() {
		return "<html>" +
				"<head>" +
				"<title>Ceiling Fan Control</title>" +
				"<script>" +
				"document.addEventListener('keypress', function(e) {" +
				"  if (e.key === 's' || e.key === 'S') {" +
				"    fetch('/pull-speed-cord', { method: 'GET' })" +
				"      .then(response => response.text())" +
				"      .then(result => console.log(result));" +
				"  } else if (e.key === 'd' || e.key === 'D') {" +
				"    fetch('/pull-direction-cord', { method: 'GET' })" +
				"      .then(response => response.text())" +
				"      .then(result => console.log(result));" +
				"  } else if (e.key === 'r' || e.key === 'R') {" +
				"    fetch('/recipe', { method: 'GET' })" +
				"      .then(response => response.text())" +
				"      .then(result => console.log(result));" +
				"  }" +
				"});" +
				"</script>" +
				"</head>" +
				"<body>" +
				"<h1>Ceiling Fan Control</h1>" +
				"<p>Press 's' to pull the speed cord and 'd' to pull the direction cord.</p>" +
				"</body>" +
				"</html>";
	}

	@GetMapping("/pull-speed-cord")
	public String pullSpeedCord() {
    	try {
        	ceilingFan.pullSpeedCord();
        	return "Speed cord pulled!";
    	} catch (Exception e) {
        	e.printStackTrace();
        	return "Error pulling speed cord!";
    	}
	}


	@GetMapping("/pull-direction-cord")
	public String pullDirectionCord() {
		try {
			ceilingFan.pullDirectionCord();
			return "Direction cord pulled!";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error pulling direction cord!";
		}
	}

	@GetMapping("/recipe")
	public String getRecipe() {
		try {
			ceilingFan.getRecipe();
			return "<html>" +
				"<head>" +
				"<title>Secret Recipe</title>" +
				"</head>" +
				"<body>" +
				"<h1>Cream Cheese Blondies Recipe</h1>" +
				"<h3>Ingredients: </h3>" +
				"<ul>" +
				"<li>1/2 cup butter</li>" +
				"<li>1/2 cup white sugar</li>" +
				"<li>1/2 cup brown sugar</li>" +
				"<li>2 eggs</li>" +
				"<li>1 teaspoon vanilla</li>" +
				"<li>1/2 teaspoon salt</li>" +
				"<li>2 teaspoons baking powder</li>" +
				"<li>1/4 teaspoon baking soda</li>" +
				"<li>1 cup flour</li>" +
				"<li>1 cup milk</li>" +
				"<li>1 cup cream cheese</li>" +
				"<li>1/2 cup chocolate chips</li>" +
				"<li>1/4 cup chopped walnuts</li>" +
				"</ul>" +
				"<h3>Method: </h3>" +
				"<ol>" +
				"<li>Preheat oven to 350 degrees F (175 degrees C).</li>" +
				"<li>In a large bowl, cream together the butter, white sugar, brown sugar, eggs, and vanilla.</li>" +
				"<li>Add the baking powder, salt, baking soda, and sifted flour. Mix well.</li>" +
				"<li>In a separate bowl, whisk together the milk, cream cheese, and chocolate chips.</li>" +
				"<li>Stir the walnuts into the cream cheese mixture.</li>" +
				"<li>Add all ingredients to one bowl and fold to combine</li>" +
				"<li>Pour the batter into a 9x9 inch pan. Bake for 35 to 40 minutes or until the top is golden brown and a tootpick inserted comes out clean.</li>"
				+
				"</ol>" +
				"</body>" +
				"</body>" +
				"</html>";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error getting recipe!";
		}
	}
}