// Part 1: Declaring and Accessing Arrays
// 1. Create an array called fruits that contains the following values: 
// "apple", "banana", "cherry", "date".
let fruits = ["apple", "banana", "cherry", "date"];

// 2. Print the entire array to the console.
console.log("Print the entire array to the console.")
console.log(fruits);

// 3. Print the first and last elements of the array using their index positions.
console.log("Print the first and last elements of the array using their index positions.");
console.log(fruits[0])
console.log(fruits[fruits.length - 1]);

// Part 2: Modifying Arrays
// 1. Replace "banana" with "blueberry".
fruits[1] = "blueberry";

// 2. Add "elderberry" to the end of the array.
fruits.push("elderberry");

// 3. Add "apricot" to the beginning of the array.
fruits.unshift("apricot");

// 4. Remove the first element from the array and print the removed value.
console.log("Remove the first element from the array and print the removed value.");
console.log(fruits.shift());

// 5. Remove the last element from the array and print the removed value.
console.log("Remove the last element from the array and print the removed value.");
console.log(fruits.pop());

// 6. Print the updated array.
console.log("Print the updated array.");
console.log(fruits);

// Part 3: Looping Through an Array
// 1. Create a loop that prints each element in the fruits array.
console.log("Create a loop that prints each element in the fruits array.");
for (let i in fruits) {
    console.log(fruits[i]);
}

// 2. Modify the loop so that it skips every other element.
console.log("Modify the loop so that it skips every other element.");
for (let i in fruits) {
    if (Number(i) % 2 === 0) {
        console.log(i, fruits[i]);
    }
}

// Part 4: Advanced Array Methods
// 1. Use .indexOf() to find the index of "cherry". Print the result.
console.log("Use .indexOf() to find the index of cherry. Print the result.");
let cherryIndex = fruits.indexOf("cherry")
console.log(cherryIndex);

// 2. Use .splice() to remove "cherry" from the array.
fruits.splice(cherryIndex);

// 3. Use .concat() to add another array ["fig", "grape", "honeydew"] to fruits.
fruits = fruits.concat(["fig", "grape", "honeydew"]);

// 4. Print the final array.
console.log(fruits);