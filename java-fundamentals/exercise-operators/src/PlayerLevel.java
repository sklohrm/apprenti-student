public class PlayerLevel {

    public static void main(String[] args) {
        // Declare and initialize variables:
        int currentXP = 1200;
        int level = 5;
        int xpToNextLevel = 1500;
        boolean levelUp;

        // 1. Use Arithmetic Operators:
        // Add +300 XP when completing a quest (+=).
        currentXP += 300;

        // Reduce xpToNextLevel dynamically as XP increases (-=).
        xpToNextLevel -= currentXP;

        // Multiply XP if player earns a double XP boost (*=).
        currentXP *= 2;

        // 2. Use Comparison Operators:
        // Check if currentXP is greater than or equal to xpToNextLevel.
        levelUp = xpToNextLevel > currentXP;
        // Check if the player has reached Level 10.
        boolean isLevelTenOrHigher = level >= 10;

        // 3. Use Logical Operators:
        // Determine if the player levels up (XP requirement met AND level < 10).
        boolean canLevelUp = xpToNextLevel < currentXP && level < 10;
        // Determine if the player is a pro (Level > 7 OR XP over 5000).
        boolean isPro = level > 7 || currentXP > 5000;

        // 4. Print the updated values and level-up status.
        System.out.println("Current XP: " + currentXP);
        System.out.println("Level: " + level);
        System.out.println("XP to next level: " + xpToNextLevel);
        System.out.println("The player " + (canLevelUp ? "can " : "cannot ") + "level up.");
        System.out.println("The player " + (isPro ? "is " : "is not ") + "a pro.");
    }


}
