# spring-ceiling-fan

[![badge](https://img.shields.io/badge/license-MIT-brightgreen.svg)](https://opensource.org/licenses/mit)

## Description

A Java Spring Boot web application for controlling and monitoring ceiling fans. This application allows users to turn fans on/off, adjust speed, change direction and view real-time status updates.

## Features

- Control fan power (on/off)
- Adjust fan speed (low, medium, high)
- Change fan direction (clockwise/counter-clockwise)
- View real-time fan status updates

## Technologies

- Java
- Spring Boot
- Spring Web MVC

## Getting Started

To run this application locally, you will need:

- Java 17 or higher
- Maven

1. Clone this repository.
2. Navigate to the project directory.
3. If you have Maven installed globally, you can run: `mvn spring-boot:run` or open in your IDE and click the run icon or run as a Java application.
4. Open your web browser and go to `http://localhost:8080`. You can now control your ceiling fan!
5. You can also test the endpoints `/pull-speed-cord` and `/pull-direction-cord` using Postman or Insomnia or manually in the web browser.

## Testing

Testing is done with JUnit Jupiter. To run tests, run: `mvn test` or open in your IDE and click the test icon.

## Contributing

Contributions are welcome! Please open an issue or submit a pull request.

## Questions

If you have an questions about this app, please contact me at [LinkedIn](https://www.linkedin.com/in/shawn-meister/). More of my work can be viewed at [Github](https://github.com/CookingMeister).

## Credits

This app was created by [CookingMeister](https://github.com/CookingMeister) on criteria from Medavie Blue Cross. [W3Schools Java docs](https://www.w3schools.com/java/) and [JUnit Jupiter docs](https://junit.org/junit5/docs/snapshot/user-guide/) were used as a reference for this app.

## License

[![badge](https://img.shields.io/badge/license-MIT-brightgreen.svg)](https://opensource.org/licenses/mit)

This project is licensed under the [MIT License](LICENSE).
