public class WeatherForecast {
    public static void main(String[] args) {
//        Declare and initialize variables
        double temperatureCelsius = 25.0;
        boolean isRaining = false;
        int windSpeedKmh = 10;

        // 1. Convert Celsius to Fahrenheit using the formula:
        // temperatureFahrenheit = (temperatureCelsius×9/5) + 32
        double temperatureFahrenheit = (temperatureCelsius * (9.0 / 5.0)) + 32;

        // 2. Use Assignment Operators:
        // Increase temperature by 5 degrees (+=)
        temperatureCelsius += 5;

        // Increase wind speed by 5 km/h (+=).
        windSpeedKmh += 5;

        // 3. Use Comparison Operators:
        // Check if the temperature in Fahrenheit exceeds 85°F.
        boolean isItFarenHot = temperatureFahrenheit > 85.0;

        // Check if the wind speed is greater than 20 km/h.
        boolean isItWindy = windSpeedKmh > 20;

        // 4. Use Logical Operators:
        // Determine if it's a good day to go outside (not raining AND temperature between 60°F - 85°F).
        boolean isItNiceOut = !isRaining && (60 < temperatureFahrenheit && temperatureFahrenheit < 85);

        // Determine if there's a weather warning (wind speed above 30 km/h OR temperature below 0°C).
        boolean isWeatherWarning = windSpeedKmh > 30 || temperatureCelsius < 0;

        // 5. Print the results in a readable format.
        System.out.println("Temperature Celsius: " + temperatureCelsius);
        System.out.println("Temperature Farenheit: " + temperatureFahrenheit);
        System.out.println("Wind Speed: " + windSpeedKmh + " Km/h");

        System.out.println();
        System.out.println("It " + (isItWindy ? "is " : "is not ") + "windy.");
        System.out.println("It " + (isRaining ? "is " : "is not ") + "raining.");
        System.out.println("It " + (isItFarenHot ? "is " : "is not ") + "hot out.");
        System.out.println("It " + (isItNiceOut ? "is " : "is not ") + "nice out.");
        System.out.println("There " + (isWeatherWarning ? "is " : "is not ") + "a weather warning.");
        
    }
}
