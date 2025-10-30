package learn.pets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication is a convenience annotation that adds:
// 1. @Configuration: Tags the class as a source of bean definitions for the application context.
// 2. @EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings.
// 3. @ComponentScan: Tells Spring to look for other components, configurations, and services
//    in the learn.pets package, allowing it to find PetJdbcRepository and PetController.
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        System.out.println("Pet REST Api is running? Access the API at http://localhost:8080/api/pet");
    }

}
