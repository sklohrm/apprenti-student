package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BirthdayManager {

    private HashMap<Friend, List<Gift>> myFriendsGifts;

    public BirthdayManager() {
        this.myFriendsGifts = new HashMap<>();
    }

    public List<Friend> getFriends() {
        return myFriendsGifts.keySet().stream().toList();
    }

    public HashMap<Friend, List<Gift>> getMap() {
        return this.myFriendsGifts;
    }

    public void addFriend(Friend newFriend) {
        myFriendsGifts.put(newFriend, new ArrayList<>());
    }

    public void addGift(Friend friend, Gift gift) {
        myFriendsGifts.get(friend).add(gift);
    }

    public void removeFriend(Friend exFriend) {
        myFriendsGifts.remove(exFriend);
    }




}
