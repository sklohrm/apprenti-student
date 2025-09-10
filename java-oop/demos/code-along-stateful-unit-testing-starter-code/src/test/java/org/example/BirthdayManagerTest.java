package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BirthdayManagerTest {

    private BirthdayManager birthdayManager;
    private Friend testFriend1;
    private Friend testFriend2;
    private Gift testGift1;
    private Gift testGift2;

    @BeforeEach
    void setUp() {
        birthdayManager = new BirthdayManager();

        testFriend1 = new Friend("Ralphie", "01/01/1901");
        testFriend2 = new Friend("Georgie", "01/01/1901");

        testGift1 = new Gift("Bag", "Small");
        testGift2 = new Gift("Water", "Bottle");


        birthdayManager.addFriend(testFriend1);
        birthdayManager.addGift(testFriend1, new Gift("Bag", "Small"));
        birthdayManager.addGift(testFriend1, new Gift("Rock", "Large"));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getFriends() {
        // Arrange
        List<Friend> expected = new ArrayList<>();
        expected.add(testFriend1);

        // Act
        List<Friend> actual = birthdayManager.getFriends();

        // Assert
        assertEquals(Set.copyOf(expected), Set.copyOf(actual));
    }

    @Test
    void addFriend() {
        // Arrange
        List<Friend> expected = new ArrayList<>();
        expected.add(0, testFriend1);
        expected.add(1, testFriend2);

        // Act
        birthdayManager.addFriend(testFriend2);
        List<Friend> actual = birthdayManager.getFriends();

        // Assert
        assertEquals(Set.copyOf(expected), Set.copyOf(actual));
    }

    @Test
    void addGift() {
        List<Gift> expected = new ArrayList<>();
        expected.add(testGift1);
        birthdayManager.addGift(testFriend1, testGift1);
    }

    @Test
    void removeFriend() {
        birthdayManager.removeFriend(testFriend1);
        assertTrue(birthdayManager.getFriends().isEmpty());
    }

    @Test
    void getGiftsForFriend() {
        List<Gift> expected = new ArrayList<>();
        expected.add(testGift1);
        expected.add(testGift2);
        List<Gift> actual = birthdayManager.getGiftsForFriend(testFriend1);
        assertEquals(expected, actual);
    }
}