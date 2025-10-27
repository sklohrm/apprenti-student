// Part 1: If Statements (Even or Odd Checker)
// Write a program that generates a random number between 1 and 50.
let randomNumber = Math.floor(Math.random() * 50) + 1;

// Check if the number is even or odd using an if statement.
// Print the result to the console.
if (randomNumber % 2 === 0) {
    console.log(`${randomNumber} is even.`);
} else {
    console.log(`${randomNumber} is odd.`);
}

// Part 2: Switch Statement (Day of the Week)
// Create a program that asks the user for a number (0-6).
let dayNumber = prompt("A number 0-6:");

// Use a switch statement to display the corresponding day of the week (0 = Sunday, 6 = Saturday).
let day;

switch (dayNumber) {
  case 0:
    day = "Sunday";
    break;
  case 1:
    day = "Monday";
    break;
  case 2:
    day = "Tuesday";
    break;
  case 3:
    day = "Wednesday";
    break;
  case 4:
    day = "Thursday";
    break;
  case 5:
    day = "Friday";
    break;
  case 6:
    day = "Saturday";
    break;
  default: day = "Unknown";
}
console.log(day);

// If the number is out of range, print an error message.
if (dayNumber > 6) {console.error(`${dayNumber} not within range. (0-6)`)}

// Part 3: While Loop (Rolling a Dice)
// Simulate rolling a dice until you get a 6.
let roll;
while (roll !== 6) {
  roll = Math.floor(Math.random() * 6) + 1;
  // Print each roll.
  console.log(`You rolled a ${roll}.`)
}


// Part 4: For Loop (Counting Down)
// Ask the user for a starting number.
let countdown = prompt("Enter a number");
countdown = Math.abs(countdown);
// Use a for loop to count down to 0.
for (let i = countdown; i >= 0; i--) {
  // Print each number.
    console.log(i)
}


