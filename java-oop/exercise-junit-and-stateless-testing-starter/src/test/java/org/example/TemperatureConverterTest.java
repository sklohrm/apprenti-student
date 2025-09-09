package org.example;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TemperatureConverterTest {

    // Setup
    private TemperatureConverter converter;

    @BeforeEach
    void setUp() {
        converter = new TemperatureConverter();
    }

    // Assert

    // Conversion from Celsius to Fahrenheit outputs correct result. Including negative values.
    @Test
    public void testCelsiusToFahrenheit(){
        // Arrange
        double[] celsiusTemperatures = {-50, 25, 100};
        double[] expectedFahrenheitTemperatures = {-58, 77, 212};
        double[] actualFahrenheitTemperatures = new double[3];

        // Act
        for (int i = 0; i < celsiusTemperatures.length; i++) {
            actualFahrenheitTemperatures[i] = converter.celsiusToFahrenheit(celsiusTemperatures[i]);
        }

        // Assert
        for (int i = 0; i < actualFahrenheitTemperatures.length; i++) {
            double expectedRounded = Math.round(expectedFahrenheitTemperatures[i] * 100.0) / 100.0;
            double actualRounded = Math.round(actualFahrenheitTemperatures[i] * 100.0) / 100.0;
            assertEquals(expectedRounded, actualRounded);
        }

    }

    // Conversion from Fahrenheit to Celsius outputs correct result. Including negative values.
    @Test
    public void testFahrenheitToCelsius(){
        // Arrange
        double[] fahrenheitTemperatures = {-58, 77, 212};
        double[] expectedCelsiusTemperatures = {-50, 25, 100};
        double[] actualCelsiusTemperatures = new double[3];

        // Act
        for (int i = 0; i < fahrenheitTemperatures.length; i++) {
            actualCelsiusTemperatures[i] = converter.fahrenheitToCelsius(fahrenheitTemperatures[i]);
        }

        // Assert
        for (int i = 0; i < actualCelsiusTemperatures.length; i++) {
            double expectedRounded = Math.round(expectedCelsiusTemperatures[i] * 100.0) / 100.0;
            double actualRounded = Math.round(actualCelsiusTemperatures[i] * 100.0) / 100.0;
            assertEquals(expectedRounded, actualRounded);
        }

    }

    // Conversion from Fahrenheit to Kelvin outputs correct result. Including negative values.
    @Test
    public void testFahrenheitToKelvin(){
        // Arrange
        double[] fahrenheitTemperatures = {-58, 77, 212};
        double[] expectedKelvinTemperatures = {223.15, 298.15, 373.15};
        double[] actualKelvinTemperatures = new double[3];

        // Act
        for (int i = 0; i < fahrenheitTemperatures.length; i++) {
            actualKelvinTemperatures[i] = converter.fahrenheitToKelvin(fahrenheitTemperatures[i]);
        }

        // Assert
        for (int i = 0; i < actualKelvinTemperatures.length; i++) {
            double expectedRounded = Math.round(expectedKelvinTemperatures[i] * 100.0) / 100.0;
            double actualRounded = Math.round(actualKelvinTemperatures[i] * 100.0) / 100.0;
            assertEquals(expectedRounded, actualRounded);
        }

    }

    // Conversion from Celsius to Kelvin outputs correct result. Including negative values.
    @Test
    public void testCelsiusToKelvin(){
        // Arrange
        double[] celsiusTemperatures = {-50, 25, 100};
        double[] expectedKelvinTemperatures = {223.15, 298.15, 373.15};
        double[] actualKelvinTemperatures = new double[3];

        // Act
        for (int i = 0; i < celsiusTemperatures.length; i++) {
            actualKelvinTemperatures[i] = converter.celsiusToKelvin(celsiusTemperatures[i]);
        }

        // Assert
        for (int i = 0; i < actualKelvinTemperatures.length; i++) {
            double expectedRounded = Math.round(expectedKelvinTemperatures[i] * 100.0) / 100.0;
            double actualRounded = Math.round(actualKelvinTemperatures[i] * 100.0) / 100.0;
            assertEquals(expectedRounded, actualRounded);
        }

    }

    // Conversion from Kelvin to Celsius outputs correct result. Including negative values.
    @Test
    public void testKelvinToCelsius(){
        // Arrange
        double[] kelvinTemperatures = {223.15, 298.15, 373.15};
        double[] expectedCelsiusTemperatures = {-50, 25, 100};
        double[] actualCelsiusTemperatures = new double[3];

        // Act
        for (int i = 0; i < kelvinTemperatures.length; i++) {
            actualCelsiusTemperatures[i] = converter.kelvinToCelsius(kelvinTemperatures[i]);
        }

        // Assert
        for (int i = 0; i < actualCelsiusTemperatures.length; i++) {
            double expectedRounded = Math.round(expectedCelsiusTemperatures[i] * 100.0) / 100.0;
            double actualRounded = Math.round(actualCelsiusTemperatures[i] * 100.0) / 100.0;
            assertEquals(expectedRounded, actualRounded);
        }

    }

    // Conversion from Kelvin to Fahrenheit outputs correct result. Including negative values.
    @Test
    public void testKelvinToFahrenheit(){
        // Arrange
        double[] kelvinTemperatures = {223.15, 298.15, 373.15};
        double[] expectedFahrenheitTemperatures = {-58, 77, 212};
        double[] actualFahrenheitTemperatures = new double[3];

        // Act
        for (int i = 0; i < kelvinTemperatures.length; i++) {
            actualFahrenheitTemperatures[i] = converter.kelvinToFahrenheit(kelvinTemperatures[i]);
        }

        // Assert
        for (int i = 0; i < actualFahrenheitTemperatures.length; i++) {
            double expectedRounded = Math.round(expectedFahrenheitTemperatures[i] * 100.0) / 100.0;
            double actualRounded = Math.round(actualFahrenheitTemperatures[i] * 100.0) / 100.0;
            assertEquals(expectedRounded, actualRounded);
        }

    }

}