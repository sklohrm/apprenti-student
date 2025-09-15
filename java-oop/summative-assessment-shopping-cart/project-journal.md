# Project Journal for Summative Assessment - Shopping Cart

Authored by: Barry Molina & Spencer Lohrmann

## Requirements

- The user is presented with the main menu.
- The user has five options:
    - Display Cart
    - Remove an item
    - Add an item
    - Checkout
    - Exit
- When removing an item from the cart, display the cart and allow the user to select which item they would like to
  remove and how many they wish to remove.
- Only remove an item from the cart when the quantity for that item is zero.
- The user can add and remove as many items to the cart as they wish.
- When the user checks out, empty their cart and display the total amount due.

## WBS

| ID  | Description                    | Dependencies | Assignee | Status |
|-----|--------------------------------|--------------|----------|--------|
| 1.  | Create Product Class           |              | B        | DONE   |
| 2.  | Create ProductRepo + interface | 1            | B        | DONE   |
| 3.  | Create ProductRepoFactory      | 1, 2         | B        | DONE   |
| 4.  | Create CartItem Class          | 1            | B        | DONE   |
| 5.  | Create AppView Class           | 1, 4         | S        | DONE   |
| 6.  | Create ShoppingCart Class      | 4            | S        | DONE   |
| 7.  | Create CheckoutService         | 4, 6         | S        | DONE   |
| 8.  | Test Product Class             | 1            | B        | DONE   |
| 9.  | Test ProductRepo               | 2            | B        | DONE   |
| 10. | Test ProductRepoFactory        | 3            | B        | DONE   |
| 11. | Test CartItem Class            | 4            | B        | DONE   |
| 12. | Test AppView Class             | 5            | B        | DONE   |
| 13. | Test ShoppingCart Class        | 6            | B        | DONE   |
| 14. | Test CheckoutService           | 7            | B        | DONE   |
| 15. | Create ShoppingCartController  | 1-7          | B, S     | DONE   |
| 16. | Test ShoppingCartController    | 15           | B, S     | DONE   |
| 17. | Implement main()               | 1-7, 15      | B, S     | DONE   |

## Process

- After reviewing the requirements we constructed a class diagram to explore the objects needed and their relationships
- We then modelled the Add Item, Remove Item, and Checkout processes using Sequence Diagrams
- See design-docs/ for copies of the above diagrams
- Based on the dependencies between classes, we constructed a Work Breakdown Structure to split up the work.

## Design Decisions

- We modelled our architecture on our previous solution to the Class Design project.
    - This meant using Factory and Repo classes to create and manage Products.
    - An AppView class will handle user interactions, and a Controller class will handle orchestration.
- Cart vs. CartService
    - We initially had a `CartService` class that maintained a list of `CartItems` added by the user
    - After some deliberation, we decided to split this class up into a standalone `ShoppingCart` entity to hold the
      `CartItems`, and a `CheckoutService` to handle the checkout process.
- To include a Map, we decided to have ProductRepo store a HashMap of Product objects mapped to their ID.
    - The user will add a product by id
- Who creates the CartItem?
    - We initially had addItem() in ShoppingCart take a Product and quantity as arguments. We decided it would be better
      for the controller to instantiate the CartItem and pass it directly into the ShoppingCart
- How does ShoppingCart.removeItem() work?
    - There are many ways to go about this, but we finally landed on passing in a Product ID to update the quantity of.
      ShoppingCart will find the CartItem with that Product and remove the specified number of items.
- Originally CheckoutService had a static method checkout, but in order to test the ShoppingCartController class we had
  to make it an instance method that could be mocked and injected
    - This meant that the controller had 4 parameters, indicating a large parameter list smell.
    - To address this we created ShoppingCartControllerConfig to collect all the needed services.
- We aimed to achieve 100% test coverage. To help achieve this, we added ShoppingCartControllerFactory to handle the
  dependency instantiation that originally resided in App.main().
- We considered using the toString() method on Product and CartItem to display their contents to the user. After
  realizing that this led to inflexibility in the specific formatting used, we pivoted to using our AppView class to
  handle user-facing formatting, reserving the toString() overrides for internal debugging and testing.

## Test Coverage 💯

This project has 100% test coverage. See `test-coverage.png` for details.