// 1. Create a string variable message and assign it the value "Welcome to JavaScript!".
let string = "Welcome to JavaScript!";

// 2. Print the length of the message string.
console.log(`Message Length: ${string.length}`);

// 3. Retrieve and print the first and last characters of message using charAt().
let firstChar = string.charAt(0);
let lastChar = string.charAt(string.length - 1);
console.log(`First Character: ${firstChar}`);
console.log(`Last Character: ${lastChar}`);

// 4. Convert message to uppercase and lowercase, then print both versions.
let stringToUpper = string.toUpperCase();
let stringToLower = string.toLowerCase();
console.log(`Uppercase: ${stringToUpper}`);
console.log(`Lowercase: ${stringToLower}`);

// 5. Use indexOf() to find the position of the word "JavaScript" in the message string.
let index = string.indexOf("JavaScript");
console.log(`Position of "JavaScript": ${index}`);

// 6. Extract and print the word "JavaScript" from the string using substring().
let javaScript = string.substring(index, index + 10);
console.log(`Extracted JavaScript: ${javaScript}`);

// 7. Replace "JavaScript" with "Coding" in the message string and print the result.
let modifiedString = string.replace("JavaScript", "Coding");
console.log(`Modified String: ${modifiedString}`);

// 1. Generate and print a random number between 1 and 100.
let randomNumber = Math.floor(Math.random() * 100) + 1;
console.log(`Random Number: ${randomNumber}`);

// 2. Calculate and print:
//    The square root of 144.
//    3 to the power of 4 using Math.pow().
//    The absolute value of -25.
let sqrtNum = Math.sqrt(144);
console.log(`Square Root of 144: ${sqrtNum}`);

// 3. Round the number 7.8 using:
//    Math.round()
//    Math.ceil()
//    Math.floor()
//    Math.trunc()
let num = 7.8;
console.log(`Math.round(): ${Math.round(num)}`);
console.log(`Math.ceil(): ${Math.ceil(num)}`);
console.log(`Math.floor(): ${Math.floor(num)}`);
console.log(`Math.trunc(): ${Math.trunc(num)}`);

// 4. Calculate and print the cosine of 45 degrees (Hint: Use Math.cos() with
//    radians).
num = 45;
let radians = num * (Math.PI / 180);
let cosine = Math.cos(radians);
console.log(`Cosine of ${num} degrees: ${cosine}`);
