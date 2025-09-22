package learn.battle;

import learn.battle.environment.Battle;
import learn.battle.environment.Location;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("battle-config.xml");

        Battle battle;
        System.out.println("how many players?");
        try {
            int input = Integer.parseInt(new Scanner(System.in).nextLine());

            if (input == 4) {
                battle = context.getBean("fourPlayer", Battle.class);
            } else {
                battle = context.getBean("eightPlayer", Battle.class);
            }
        } catch (Exception e) {
            // Bug causes infinite loop when all Fighters reference the same object.
            battle = context.getBean("singletonGame", Battle.class);
        }

        battle.run();
    }
}

//How did changing the scope from singleton to prototype affect the battle?
// Changing a Fighter bean from singleton to prototype makes them refer to different objects.

//Try adding different announcers or messages. How does changing announcers impact the game experience?
// Changing announcer from Mumbler to ProperAnnouncer allows you to actually understand what is happening.

//For every battle setup, consider:
// ○ What was easy or difficult about configuring this battle?
// It seems pretty easy to create new configurations.

// ○ How did using Spring DI help you create unique configurations with minimal changes?
// If you set up different beans that you might need, it makes it easy to put them together in new combinations.
// I can also see how this could be setup to have some code run on startup that will use different configurations based
// on things like launch options or user input or whatever you want. I messed around with it a bit at the top and
// used a different config based on user input.

