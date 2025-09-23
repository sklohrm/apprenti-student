package learn.spaceflight;

import learn.spaceflight.personnel.Astronaut;
import learn.spaceflight.spacecraft.MoonHopper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        // Spring code here...
        ApplicationContext container = new ClassPathXmlApplicationContext("dependency-configuration.xml");
        Astronaut captain = container.getBean("captain", Astronaut.class);
        Astronaut crew = container.getBean("crew", Astronaut.class);
        MoonHopper moonHopper = container.getBean("moonHopper", MoonHopper.class);

        System.out.println("Captain: " + captain);
        System.out.println("Crew: " + crew);
    }
}
