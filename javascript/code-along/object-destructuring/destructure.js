const me = {
    name: "Spencer",
    age: 29,
    stats: {
        mileTime: "3:00",
        maxBench: "290",
    },
    isLying: true,
};

function initializeForm() {
    const name = document.getElementById("name");
    const age = document.getElementById("age");
    const mile = document.getElementById("mile");
    const bench = document.getElementById("bench");
    const lying = document.getElementById("lying");

    name.value = me.name;
    age.value = me.age;
    mile.value = me.stats.mileTime;
    bench.value = me.stats.maxBench;
    lying.checked = me.isLying;
}

function updateMe() {
    const name = document.getElementById("name");
    const age = document.getElementById("age");
    const mile = document.getElementById("mile");
    const bench = document.getElementById("bench");
    const lying = document.getElementById("lying");

    me.name = name.value;
    me.age = age.value;
    me.stats.mileTime = mile.value;
    me.stats.maxBench = bench.value;
    me.isLying = lying.checked;

    console.log(me);

    const meJSON = JSON.stringify(me);
    console.log(meJSON);
}

document.addEventListener('DOMContentLoaded', function () {
    initializeForm();
});

document.getElementById("formSubmit").addEventListener('click', function(event) {
    event.preventDefault();
    updateMe();
});