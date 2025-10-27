// Part 1: Function Basics
// 1. Create a function named greetUser that takes a name as an argument and prints "Hello, [name]!"
function greetUser(name) {
    console.log(`Hello, ${name}!`);
}

// 2. Call greetUser twice with different names.
greetUser("Ant");
greetUser("Spencer");

// Part 2: Returning Values
// 1. Create a function named squareNumber that takes a number as an argument and returns its square
function squareNumber(input) {
    return Math.pow(input, 2);
}

// 2. Call squareNumber with 4 and 7, storing the results in variables.
let fourSquared = squareNumber(4);
let sevenSquared = squareNumber(7);

// 3. Print both results to the console.
console.log(`Four squared is: ${fourSquared}.`);
console.log(`Seven squared is: ${sevenSquared}.`);

// Part 3: Multiple Parameters
// 1. Create a function named addNumbers that takes two numbers as arguments and returns their sum.
function addNumbers(x, y) {
    return x + y;
}

// 2. Call addNumbers(10, 5) and addNumbers(3, 8).
let tenPlusFive = addNumbers(10, 5);
let threePlusEight = addNumbers(3, 8);

// 3. Print both results.
console.log(`Ten plus five is: ${tenPlusFive}.`);
console.log(`Three plus eight is: ${threePlusEight}.`);

// Part 4: Random Color Generator
// Create a function named getRandomColor that returns a random color from this array:
let colors = ["red", "blue", "green", "yellow", "purple", "orange"];

function getRandomColor() {
    let randomIndex = Math.floor(Math.random() * colors.length);
    return colors[randomIndex];
}

// Call getRandomColor() three times and print the results.
console.log(`Random color: ${getRandomColor()}.`);
console.log(`Random color: ${getRandomColor()}.`);
console.log(`Random color: ${getRandomColor()}.`);

// Part 5: Random Fortune Teller
// Create a function named tellFortune that selects a random fortune from this array:
let fortunes = [
"You will have a great day!",
"A surprise is waiting for you.",
"Something exciting is coming soon.",
"Be cautious with your decisions today.",
"Happiness is around the corner."
];

function tellFortune() {
    let randomIndex = Math.floor(Math.random() * fortunes.length);
    return fortunes[randomIndex];
}

// Call tellFortune() and print the result.
console.log(tellFortune());