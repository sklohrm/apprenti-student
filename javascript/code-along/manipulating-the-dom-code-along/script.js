function changeBackgroundColor() {
  const bodyElement = document.querySelector("body");
  bodyElement.style.backgroundColor = '#' + (Date.now() % 0xFFFFFF).toString(16).padStart(6, '0');
}

function addListItem() {
  const list = document.getElementById("itemList");
  const newItem = document.createElement("li");
  const itemText = document.createTextNode("Item");
  newItem.appendChild(itemText);

  // --- New lines for complementary color ---
  const currentColor = (Date.now() % 0xFFFFFF).toString(16).padStart(6, '0');
  const complementaryColor = invertHex(currentColor);
  newItem.style.color = complementaryColor;
  // ----------------------------------------

  list.appendChild(newItem);
}

function invertHex(hex) {
  const inverted = (0xFFFFFF ^ parseInt(hex, 16)).toString(16).padStart(6, '0');
  return `#${inverted}`;
}

const myButton = document.getElementById("changeColor");
myButton.addEventListener("click", changeBackgroundColor);

const addItemButton = document.getElementById("addItem");
addItemButton.addEventListener("click", () => {
  changeBackgroundColor();
  addListItem();
});
