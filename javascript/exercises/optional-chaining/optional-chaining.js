const book = {
    title: "JavaScript Basics",
    author: {
        name: "John Doe",
        social: {
            twitter: "@johndoe"
        }
    }
};
console.log(book.author?.social?.twitter);
console.log(book.publisher.name);

// What happens when you try to access book.publisher?.name?
//  Optional chaining stops the evaluation when publisher is undefined and returns.
//
// How does optional chaining prevent errors in this scenario?
//  If it had not stopped when publisher was undefined, it would have tried to access the name field
//  on the nonexistent publisher property and thrown an error.
//
// What would happen if we removed ?. in book.publisher?.name?
//  I think I answered it in the last question.
//  Here is the output: 
//  TypeError: Cannot read properties of undefined (reading 'name')