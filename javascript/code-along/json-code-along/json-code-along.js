let cat = {
    name: "Fluffy",
    breed: "Bombay Cat",
    age: 3,
    meow: function() {
        return `${this.name} says "Meow!"`;
    }
}

let owner = {
    name: "John Doe",
    city: "Milwaukee",
}

let ownerAddress = {
    address: "1212 Boogie Woogie Avenue",
    state: "Wisconsin"
}

let pName = document.getElementById("name");
pName.innerText = pName.innerText + " " + cat.name;

let pBreed = document.getElementById("breed");
pBreed.innerText = pBreed.innerText + " " + cat.breed;

let pStatement = document.getElementById("statement");
pStatement.innerText = cat.meow();

cat.age = 4;
let pAge = document.getElementById("age");
pAge.innerText = cat.age;

cat.color = "Gray";
let pColor = document.getElementById("color");
pColor.innerText = cat.color;

cat.owner = owner;

let pOwner = document.getElementById("ownerName")
pOwner.innerText = cat.owner.name;

cat.owner.address = ownerAddress;

let cup1 = { color: "blue", vol: 12 };
let cup2 = { color: "blue", vol: 12 };
let cup3 = cup2;

console.log(cup1 === cup2);
console.log(cup2 === cup3);

let catJSON = JSON.stringify(cat);
console.log(catJSON);

let cat2 = JSON.parse()