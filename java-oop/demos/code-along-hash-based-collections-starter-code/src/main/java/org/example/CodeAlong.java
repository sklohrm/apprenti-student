package org.example;

public class CodeAlong {

    public static void main(String[] args) {
        BirthdayManager myBirthday = new BirthdayManager();

        System.out.println("Adding new friend Ralph");
        Friend ralph = new Friend("Ralph", "1/1/1901");
        myBirthday.addFriend(ralph);

        System.out.println("Adding new friend Mike");
        Friend mike = new Friend("Mike", "6/6/1966");
        myBirthday.addFriend(mike);

        System.out.println("\nMy Friends");
        for (Friend friend : myBirthday.getFriends()) {
            System.out.println(friend);
        }

        myBirthday.addGift(ralph, new Gift("Old Gold Red 100", "Carton"));
        myBirthday.addGift(ralph, new Gift("Black Suspenders", "2XLT"));

        myBirthday.addGift(mike, new Gift("Egg", "Large"));
        myBirthday.addGift(mike, new Gift("Egg", "Large"));
        myBirthday.addGift(mike, new Gift("Egg", "Large"));
        myBirthday.addGift(mike, new Gift("Hand Mixer", "Normal Size"));

        System.out.println("\nWhat they got me");
        for (Friend friend : myBirthday.getFriends()) {
            for (Gift gift : myBirthday.getMap().get(friend)) {
                System.out.println(friend.name + " got me a " + gift.size + " " + gift.description);
            }
        }

    }

}
