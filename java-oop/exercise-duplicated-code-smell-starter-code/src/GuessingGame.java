public class GuessingGame {
    public static void main(String[] args) {

        // I didn't see any problems with duplicated code in this file. The only change that I made was to call for
        // getPositiveMoney so that I could test that it works.
        // UPDATE: Followed your implementation of getNameWithDefault, but left the number logic in this class just
        // so that both int methods will be called.

        ConsoleIO myIO = new ConsoleIO();
        String name, favoriteColor, favoriteAnimal;
        int favoriteNumber;
        double cash;

        myIO.writeMessage("Welcome to my guessing game");

        myIO.writeMessage("Please answer a series of questions.");

        name = myIO.getNameWithDefault("What is your name?", "Nobody");

        favoriteColor = myIO.getInput("What's your favorite color?");

        favoriteNumber = myIO.getInteger("What's your favorite number?");

        if (favoriteNumber < 1111 || favoriteNumber > 9999) {
            favoriteNumber =
                    myIO.getIntegerInBetween(
                            "I mean what is your favorite number between 1111 and 9999"
                            , 1111, 9999);
        }

        favoriteAnimal = myIO.getNonNullNonEmptyString("What is your favorite animal?");

        cash = myIO.getPositiveMoney();

        myIO.writeMessage("Thanks for playing my game!");
        myIO.writeMessage("Your name is: " + name);
        myIO.writeMessage("Your favorite color is: " + favoriteColor);
        myIO.writeMessage("Your favorite animal is: " + favoriteAnimal);
        myIO.writeMessage("Your cash on hand is :" + cash);
        myIO.writeMessage("Finally my guess at your bank pin is :" + favoriteNumber);


    }
}
