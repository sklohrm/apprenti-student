package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class GiftTest {

    private final String DESCRIPTION = "Bowling Ball";
    private final String SIZE = "14";
    private Gift testGift;

    @BeforeEach
    void setUp() {
        testGift = new Gift(DESCRIPTION, SIZE);
    }

    @Test
    void getDescription() {
        // Arrange
        String expected = DESCRIPTION;
        // Act
        String actual = testGift.getDescription();
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void setDescription() {
        // Arrange
        String expected = "Changed Description";
        // Act
        testGift.setDescription(expected);
        String actual = testGift.getDescription();
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void getSize() {
        // Arrange, Act, Assert
        assertEquals(SIZE, testGift.getSize());
    }

    @Test
    void setSize() {
        // Arrange
        String expected = "Long";

        // Act
        testGift.setSize(expected);
        String actual = testGift.getSize();

        // Assert
        assertEquals(expected, actual);
    }
}