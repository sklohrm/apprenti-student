package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ThermostatTest {

    // Setup
    private Thermostat testThermostat;
    private final int TARGET_TEMP = 72;
    private final int TOLERANCE = 2;

    @BeforeEach
    void setUp() {
        // Create a new Thermostat
        testThermostat = new Thermostat();
        testThermostat.setTargetTemperature(TARGET_TEMP);
        testThermostat.setTolerance(TOLERANCE);
    }

    // Assert

    // 1. ThermostatBehavior.ON_HEAT when temp is below tolerance
    @Test
    public void thermostatReturnsOnHeatWhenBelowTolerance() {
        // Arrange
        int[] temperatures = {72, 70, 68, 69, 70};
        Thermostat.ThermostatBehavior expectedResult = Thermostat.ThermostatBehavior.ON_HEAT;

        // Act
        Thermostat.ThermostatBehavior actualResult = testThermostat.readSensorData(temperatures);

        // Assert
        assertEquals(expectedResult, actualResult);
    }

    // 2. ThermostatBehavior.ON_AC when temp is above tolerance
    @Test
    public void thermostatReturnsOnACWhenAboveTolerance() {
        // Arrange
        int[] temperatures = {74, 76, 75, 75, 76};
        Thermostat.ThermostatBehavior expectedResult = Thermostat.ThermostatBehavior.ON_AC;

        // Act
        Thermostat.ThermostatBehavior actualResult = testThermostat.readSensorData(temperatures);

        // Assert
        assertEquals(expectedResult, actualResult);
    }

    // 3. ThermostatBehavior.OFF when temp is within tolerance
    @Test
    public void thermostatReturnsOffWhenWithinTolerance() {
        // Arrange
        int[] temperatures = {72, 70, 69, 71, 70};
        Thermostat.ThermostatBehavior expectedResult = Thermostat.ThermostatBehavior.OFF;

        // Act
        Thermostat.ThermostatBehavior actualResult = testThermostat.readSensorData(temperatures);

        // Assert
        assertEquals(expectedResult, actualResult);
    }

    // 4. getThermostat returns the set target temperature
    @Test
    public void testGetTargetTempReturnsCorrectTemp() {
        // Arrange
        int expected = TARGET_TEMP;

        // Act
        int actual = testThermostat.getTargetTemperature();

        // Assert
        assertEquals(expected, actual);
    }

    // 5. getTolerance returns the set tolerance
    @Test
    public void testGetToleranceReturnsCorrectTolerance() {
        // Arrange
        int expected = TOLERANCE;

        // Act
        int actual = testThermostat.getTolerance();

        // Assert
        assertEquals(expected, actual);
    }

    // Tear Down


}
