// Task 1: Create a Car object
let car = {
    make: "Toyota",
    model: "Corolla",
    year: 2021,
    color: "red",
    drive: function () {
        console.log("The car is driving.");
    },
};
// Call the drive() function.
car.drive();

// Modify the Car object
// Change the color of the Car object to "blue".
car.color = "blue";

// Add a new property fuelType and set it to "gasoline".
car.fuelType = "gasoline";

// Delete the year property from the Car object.
delete car.year;

// Task 3: Create a Driver object
// Create an object called Driver with the following properties:
// name: The name of the driver (e.g., "John")
// licenseNumber: The driver's license number (e.g., "ABC123456")
// age: The driver's age (e.g., 30)
let driver = {
    name: "John",
    licenseNumber: "ABC123456",
    age: 30,
};

// Add the Driver object as a property of the Car object.
car.driver = driver;

// Display the driver's name using the dot notation.
console.log(car.driver.name);

// Task 5: Parse a JSON string into a Car object
// Use JSON.parse() to convert a JSON string representing a car back into a JavaScript object.
let carString = JSON.parse(
    '{"make":"Ford", "model":"Mustang", "year":2022, "color":"black","fuelType":"electric"}'
);

// Print the new object to the console.
console.log(carString);
