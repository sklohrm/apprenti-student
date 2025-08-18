import java.util.Scanner;

public class Decisions {
    public static void main(String[] args) {

        String userInput;
        boolean stuckInATimeLoop;

        // 1. Welcome the player and explain the scenario
        // - Print an introduction message
        introArt();
        System.out.println("All art generated collectively by ChatGPT, without original author permission.");
        System.out.println("For best results, maximize your terminal.\n");

        do {
            stuckInATimeLoop = false;
            System.out.println("You come upon a mysterious cave.");
            System.out.println("You feel compelled to enter. What will you do?\n");

            // - Ask if they want to enter the cave
            // - Get user input (yes/no)
            userInput = getValidInput("Enter the cave?", "y", "n");

            // 2. If they enter, present two path choices (left or right)
            if (userInput.equals("y")) {
                forkArt();
                System.out.println("You ignore the signs warning you to KEEP OUT and you enter the cave.\n");
                System.out.println("After what feels like an eternity of slowly descending the dank");
                System.out.println("and winding passage, you come upon a fork in the path.\n");
                userInput = getValidInput("Do you choose to go right or left?", "l", "r");

                // - Use an if-else statement to process the decision
                if (userInput.equals("l")) {

                    // - If they go left, introduce an obstacle or creature
                    archArt();
                    System.out.println("\tAfter much thought you take the passage to the left. As you continue, the natural cave");
                    System.out.println("walls begin to look as though they were carved out of the earth. By man, or some other");
                    System.out.println("creature? You can't be sure.\n");
                    System.out.println("\tYou reach a small set of steps leading to a large archway covered in glistening runes.");
                    System.out.println("You aren't able to discern their meaning. A thick wooden door hangs precariously on one");
                    System.out.println("hinge. It is covered in deep claw marks.\n");
                    System.out.println("You ignore all of this and enter the room.\n");
                    System.out.println("The earth lurches as a giant gelatinous cube comes crashing onto the ground before you.\n");


                    // 3. If they go left, ask if they want to fight or flee
                    userInput = getValidInput("Do you choose to fight or flee?", "fight", "flee");
                    // - Use a nested if statement to handle the fight scenario
                    if (userInput.equals("fight")) {
                        userInput = getValidInput(
                                "What will you use to fight creature?",
                                "dagger",
                                "frostbolt"
                        );
                        // - If they fight, print a success/failure message
                        if (userInput.equals("dagger")) {
                            System.out.println("You stab the ooze with your dagger, but can't seem to pull it loose. Before you have time ");
                            System.out.println("to drop it, the ooze has already covered your hand and most of your arm. You struggle ");
                            System.out.println("ineffectually to free yourself, and before you know it you have been completely enveloped.");
                            consumedArt();

                        } else {
                            oozeBoomArt();
                            System.out.println("You conjure a frostbolt and shoot it at the ooze. It freezes solid and immediately explodes.");
                            System.out.println("You continue into the room, ready for whatever awaits you.");
                            System.out.println("The story continues in C A V E G A M E Vol. 2! Available now at a ComputerLand near you!");

                        }
                    } else {
                        // - If they flee, print a message that they barely escaped
                        System.out.println("\n\tYou waste no time in turning around to flee. You continue running back through the cave.");
                        System.out.println("When you reach the entrance you don't stop running. You continue all the way back to the last");
                        System.out.println("tavern you visited, and regale the patrons with your deeds of great valor. They buy you drinks");
                        System.out.println("and you all party deep into the night. Later, find yourself stumbling to your room, assisted by");
                        System.out.println("the server that has been eying you for the entire night. They come into the room with you and");
                        System.out.println("you stumble onto the bed. To your surprise, instead of joining you, they draw a blade. They");
                        System.out.println("utter some type of curse in a language you have never heard, and plunge the blade into your chest.\n");

                        System.out.println("\tYou awake the next morning in a cold sweat. You must have dreamt it all. You get dressed and");
                        System.out.println("make your way downstairs for breakfast. You plan to begin a new adventure today, following a lead");
                        System.out.println("to a cave that is said to contain untold riches, and unfathomable perils. The server greets you");
                        System.out.println("and offers stew and a small loaf of bread. You thank them and they leave. You pick up your utensils");
                        System.out.println("to start eating, but your hunger has left you. Instead all you feel is a pain in your chest and a");
                        System.out.println("strong pull, almost a compulsion, to head out so that you can enter the cave.\n");
                        timeArt();
                        stuckInATimeLoop = true;
                    }
                } else {
                    // - If they go right, introduce a treasure room
                    treasureArt();
                    System.out.println("You immediately turn right, as if you are a character in some type of game where the creator spent too ");
                    System.out.println("much time on the left path, and is in a hurry to finish so that he can move on to his next assignment.");
                    System.out.println("You come upon a chamber with three pedestals, each holding a treasure, on the floor before them is a bronze placard. It reads, ");
                    System.out.println("'Smooth jazz is playing in the background.' You don't understand what this means, but you hear a pleasant ");
                    System.out.println("song playing. You stand there swaying to the music and drooling like a fool for some time. A disembodied ");
                    System.out.println("voice chimes in, saying, 'You really do need to do this quicker. This was supposed to be the shorter route ");
                    System.out.println("but you already have almost as many lines written as the other path.' Again, you aren't sure what this is ");
                    System.out.println("supposed to mean, but it spurs you to choose.\n");

                    userInput = getValidInput("Which treasure will you take?", "gem", "key", "book");
                    // 4. If they go right, present a switch menu with artifact choices
                    // - Display three options (e.g., a gem, a key, a book)
                    // - Use a switch statement to determine the outcome of their choice
                    // - Each case should have a unique consequence
                    switch (userInput) {
                        case "gem":
                            gemArt();
                            System.out.println("You take the gem off of the pedestal and try to put it in your pocket. Instead it flies free ");
                            System.out.println("from your hand and lodges itself into your eye, giving you super sight. You notice a door to your ");
                            System.out.println("right and decide to go through it. ");
                            break;
                        case "key":
                            keyArt();
                            System.out.println("You take the key off of the pedestal and notice that it was covering a keyhole. You try using the key ");
                            System.out.println("on it, and it opens a door to your right. You decide to go through it.");
                            break;
                        case "book":
                            bookArt();
                            System.out.println("You take the book off of the pedestal, open it to a random page, and begin reading a random line. Just ");
                            System.out.println("like how a normal person reads a book. A door to your right opens and you decide to go through it.");
                            break;
                        default:
                            System.out.println("Something happened.");
                            break;
                    }
                    System.out.println("You continue into the room, ready for whatever awaits you.");
                    System.out.println("The story continues in C A V E G A M E Vol. 2! Available now at a ComputerLand near you!");
                }
            } else {
                System.out.println("You decide not to enter, and continue on your way. You swear to yourself that you will have the courage ");
                System.out.println("to enter the next cave that you find.\n");
                stuckInATimeLoop = true;
            }
        } while (stuckInATimeLoop);

        System.out.println("Thanks for playing!");
    }

    private static void bookArt() {
        System.out.println("      ////\\\\");
        System.out.println("     ////  \\\\");
        System.out.println("     |  O O  |");
        System.out.println("     |  \\_/  |");
        System.out.println("      \\_____/");
        System.out.println("       /|\\");
        System.out.println("      / | \\");
        System.out.println("        |");
        System.out.println("       / \\");
        System.out.println("      /   \\");
        System.out.println("     (=====)   <- Book in hands");
    }

    private static void keyArt() {
        System.out.println("       _________");
        System.out.println("      |         |");
        System.out.println("      |    O  __|__  <- KEY");
        System.out.println("      |       |  o |");
        System.out.println("      |_______|____|");
    }

    private static void gemArt() {
        System.out.println("     .-\"\"-.");
        System.out.println("   * | O <> | *");
        System.out.println("  *  | \\_/  |  *");
        System.out.println("     | /|\\  |");
        System.out.println("     |  |   |");
        System.out.println("    /   |   \\");
    }

    private static void treasureArt() {
        System.out.println("       ╔════════════════════════════════╗");
        System.out.println("       ║                                ║");
        System.out.println("       ║      * [ GEM ] *    * [ KEY ] *    * [ BOOK ] *      ║");
        System.out.println("       ║        ___         ___         ___               ║");
        System.out.println("       ║       /   \\       /   \\       /   \\              ║");
        System.out.println("       ║      |  <> |     |  () |     |  {} |             ║");
        System.out.println("       ║       \\___/       \\___/       \\___/              ║");
        System.out.println("       ║                                                ║");
        System.out.println("       ║                                                ║");
        System.out.println("       ║               ┌───────────┐                    ║");
        System.out.println("       ║               │ SMOOTH    │                    ║");
        System.out.println("       ║               │  JAZZ     │                    ║");
        System.out.println("       ║               └───────────┘                    ║");
        System.out.println("       ╚════════════════════════════════╝");
    }

    private static void oozeBoomArt() {
        System.out.println("      *  ❄  *  ");
        System.out.println("     *   ❄    * ");
        System.out.println("       ( oo )  ");
        System.out.println("      ( ooo )  ");
        System.out.println("       (oo)    ");
        System.out.println("    *   ||   *  ");
        System.out.println("     *  ||  *   ");
        System.out.println("       BOOM!    ");
    }

    private static void timeArt() {
        System.out.println("[∞]  ∞  [∞]  ∞  [∞]  ∞  [∞]  ∞  [∞]  ∞  [∞]  ∞  [∞]  ∞  [∞]");
        System.out.println();
        System.out.println("  .-''''-.         ~~~~~~~~~~~~~~~~~~        .-''''-.");
        System.out.println(".'        '.      /                 \\      .'        '.");
        System.out.println("/ .----.   \\     |  <><>    <><>    |    / .----.   \\");
        System.out.println("| /      \\  |      \\                 /    | |    |   |");
        System.out.println("| | () () | |           T I M E  I S         | | /\\ |  |");
        System.out.println("\\ \\  /\\  / /      A  F L A T                  \\ '--'  /");
        System.out.println(" '.--'  .'               C I R C L E             '.    .'");
        System.out.println("   '-..-'                                        '-..-'");
        System.out.println();
        System.out.println("[∞]  ∞  [∞]  ∞  [∞]  ∞  [∞]  ∞  [∞]  ∞  [∞]  ∞  [∞]  ∞  [∞]\n");
    }

    private static void consumedArt() {
        System.out.println("------------- YOU DIED -------------");
        System.out.println("        _______");
        System.out.println("       /       \\");
        System.out.println("      |  O   O  |");
        System.out.println("      |   \\_/   |");
        System.out.println("       \\_______/");
        System.out.println("       ___|_|___");
        System.out.println("      /         \\");
        System.out.println("     |  ~~~~~~~  |");
        System.out.println("     |  (o o)    |");
        System.out.println("     |   \\_/     |");
        System.out.println("     |   O       |");
        System.out.println("     |  /|\\      |");
        System.out.println("     |  / \\      |");
        System.out.println("     \\___________/");
        System.out.println("------------- YOU DIED -------------");
    }

    private static void archArt() {
        System.out.println("         + * # @ % + * # @ % +");
        System.out.println("        /                     \\");
        System.out.println("       /  % & $ !       % & $ ! \\");
        System.out.println("      /___________________________\\");
        System.out.println("     |  + * # @           + * # @ |");
        System.out.println("     |  % & $ !           % & $ ! |");
        System.out.println("     |        [  ARCH  ]          |");
        System.out.println("     |        [  WAY   ]          |");
        System.out.println("     |  + * # @           + * # @ |");
        System.out.println("     |  % & $ !           % & $ ! |");
        System.out.println("     |_____________________________|");
    }

    private static void forkArt() {
        System.out.println("          /\\       /\\");
        System.out.println("         /  \\     /  \\");
        System.out.println("        /    \\   /    \\");
        System.out.println("       /      \\ /      \\");
        System.out.println("      /        X        \\");
        System.out.println("     /        / \\        \\");
        System.out.println("    /        /   \\        \\");
        System.out.println("   /        /     \\        \\");
        System.out.println("  /        /       \\        \\");
        System.out.println(" /  /\\    /         \\    /\\  \\");
        System.out.println("/__/  \\__/           \\__/  \\__\\");
        System.out.println("   Left                   Right");
    }

    private static void introArt() {
        System.out.println("          O");
        System.out.println("         /|>         ~~");
        System.out.println("         / \\        /   \\");
        System.out.println("                   /     \\");
        System.out.println("        ^   ^     /       \\     ^   ^");
        System.out.println("       ^^^ ^^^  /         \\   ^^^ ^^^");
        System.out.println("      ^^^^^^^^ /           \\ ^^^^^^^^");
        System.out.println("     ^^^^^^^^^/             \\^^^^^^^^^");
        System.out.println("       _______/               \\_______");
        System.out.println("      /                                \\");
        System.out.println("     |     ~ ~C A V E G A M E~ ~        |");
        System.out.println("      \\________________________________/");
    }

    private static String getValidInput(String question, String... options) {
        Scanner console = new Scanner(System.in);
        String input;

        StringBuilder prompt = new StringBuilder("( ");
        for (int i = 0; i < options.length; i++) {
            prompt.append(options[i]);
            if (i < options.length - 1) {
                prompt.append(" / ");
            }
        }
        prompt.append(" ): ");
        prompt.insert(0, question + " ");

        while (true) {
            System.out.print(prompt);
            input = console.nextLine().toLowerCase();

            for (String option : options) {
                if (input.equals(option)) {
                    return input;
                }
            }

            System.out.println("Invalid input. Try again.");
        }
    }
}
