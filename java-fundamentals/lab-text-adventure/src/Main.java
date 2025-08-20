import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        // Initialize Variables
        boolean visitedToadsHouse = false;
        boolean visitedLuigisMansion = false;
        boolean starToad = false;
        boolean starLuigi = false;
        boolean running = true;

        System.out.println("   Welcome to Mario World 🕹️   ");
        System.out.println(" ⭐️ Collect 2 Stars to unlock Bowser's Castle ⭐️ ");
        while (running){
            // Hub Menu
            System.out.println("You've landed at Mario's Museum! There are 4 paintings in front of you: ");
            System.out.println("Which painting would you like to jump into? 🖌️");
            System.out.println("[1] Toad's House 🍄");
            System.out.println("[2] Luigi's Mansion 🏯");
            System.out.println("[3] Bowser's Castle 🏰(locked until you have 2 Stars)");
            System.out.println("[4] Exit 🏃🏽‍♂️");
            System.out.println("Enter 1, 2, 3, or 4: ");
            int input = 0;
            while(true){
                try{
                    input = Integer.parseInt(in.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input. Enter 1, 2, 3, or 4: ");
                }
            }
            switch (input){
                // Visit Toads House (say something to collect star)
                case 1:
                    if (visitedToadsHouse){
                        // Location 1 : Toad's House
                        System.out.println("You have entered Toad's House 🍄");
                        System.out.println("This looks familiar...you have been here before.🤔");
                    } else{
                        System.out.println("You have entered Toad's House 🍄");
                        System.out.println("Find Toad under Mushroom");
                        System.out.println("You've found Toad!");
                        System.out.println("Ask Toad for the Star");
                        String askstar = in.nextLine();
                        System.out.println("Toad hands you a Star ⭐️ Nice!");
                        visitedToadsHouse = true;
                        starToad = true;
                    }
                    break;
                // Visit Luigi's Mansion (guess correct amount of ghosts to collect star)
                case 2:
                    if (visitedLuigisMansion){
                        // Location 2 : Luigi's Mansion
                        System.out.println("You have entered Luigi's Mansion 🏯");
                        System.out.println("You have been here before.");
                    } else{
                        System.out.println("You have entered Luigi's Mansion 🏯");
                        Random random = new Random();
                        int numberOfGhosts = random.nextInt(10) + 1;
                        for (int i = 0; i < numberOfGhosts; i++) {
                            System.out.print("👻");
                        }
                        System.out.println("\nGuess the number of Ghosts 👻 to collect Star: ");
                        while(true){
                            try{
                                input = Integer.parseInt(in.nextLine());
                                if(input==numberOfGhosts){
                                    System.out.println("You guessed correctly!! You get a Star ⭐️");
                                    break;
                                }
                                System.out.println("Guess Again");
                                continue;
                            } catch (Exception e) {
                                System.out.println("Invalid input. Enter a number: ");
                            }
                        }
                        visitedLuigisMansion = true;
                        starLuigi = true;
                    }
                    break;
                // Visit Bowser's Castle (must have 2 stars and fight Bowser to save princess peach)
                case 3:
                    if (starToad && starLuigi) {
                        // Location 3 : Bowser's Castle
                        System.out.println("Congratulations you have unlocked Bowser's Castle!! 🏰");
                        System.out.println("Fight Bowser to save Princess Peach 👸🏼");
                        System.out.println("[1] Ground Pound 🧱");
                        System.out.println("[2] Fire Ball ☄️ ");
                        System.out.println("[3] Star Power 🌟");
                        while(true){
                            try{
                                input = Integer.parseInt(in.nextLine());
                                break;
                            } catch (Exception e) {
                                System.out.println("Invalid input. Enter 1, 2, 3: ");
                            }
                        }
                        if(input == 1){
                            System.out.println("Ground Pound was blocked by Bowsers shell");
                            System.out.println("You Lose ❌");
                        } else if(input == 2){
                            System.out.println("Fire doesn't work on Bowser 🔥");
                            System.out.println("You Lose ❌");
                        } else{
                            System.out.println("Star power destroys Bowser 💫🐢!!!");
                            System.out.println("You've saved Princess Peach! 👸🏼 You Won 🏆" );
                        }
                        // restart logic if true (reset variables)
                        System.out.println("Play Again? (y/n) 🕹️");
                        String gameRestart = "";
                        while(true){
                            gameRestart = in.nextLine();
                            if(gameRestart.equalsIgnoreCase("y")) {
                                visitedToadsHouse = false;
                                visitedLuigisMansion = false;
                                starToad = false;
                                starLuigi = false;
                                break;
                            } else if(gameRestart.equalsIgnoreCase("n")){
                                running = false;
                                break;
                            }
                            else{
                                System.out.println("Invalid input. Please enter y or n");
                            }
                        }
                    } else{
                        System.out.println("You bounced off the paintings");
                        System.out.println(" ⭐ 2 Stars must be collected to enter ⭐️ ");

                    }
                    break;
                // Exit Game
                case 4:
                    running = false;
                    break;
                default:
                    break;


            }
        }
        // Ending
        System.out.println("Thanks for visiting Mario's Museum!!!");

    }
}