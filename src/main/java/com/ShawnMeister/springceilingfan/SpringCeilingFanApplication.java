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
		SpringApplication.run(SpringCeilingFanApplication.class, args);
		System.out.println("Hello, I am a big fan");
	}

	@GetMapping("/")
    public String index() {
        return "<html>" +
                "<head>" +
                "<script>" +
                "document.addEventListener('keypress', function(event) {" +
                "  if (event.key === 's' || event.key === 'S') {" +
                "    fetch('/pull-speed-cord', { method: 'GET' })" +
                "      .then(response => response.text())" +
                "      .then(result => console.log(result));" +
                "  } else if (event.key === 'd' || event.key === 'D') {" +
                "    fetch('/pull-direction-cord', { method: 'GET' })" +
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
		ceilingFan.pullSpeedCord();
		return "Speed cord pulled";
	}

	@GetMapping("/pull-direction-cord")
	public String pullDirectionCord() {
		ceilingFan.pullDirectionCord();
		return "Direction cord pulled";
	}
}