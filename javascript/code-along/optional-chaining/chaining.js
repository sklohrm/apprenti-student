const person = {
    name: "Rocco",
    age: 13,
    contact: {
        email: "rocco@email.com",
        phone: "111-222-3456",
        twitter: "roccoTweets"
    }
};

const person2 = {
    name: "Preston",
    age: 12,
};

let people = [person, person2];

console.log(people);

if (person.contact.twitter) {
    console.log(person.contact.twitter);
}
