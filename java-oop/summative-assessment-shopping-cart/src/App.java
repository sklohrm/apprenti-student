import controller.factory.ShoppingCartControllerFactory;

public class App {

    public static void main(String[] args) {

        // Fetch and instance of ShoppingCartController and run the app
        ShoppingCartControllerFactory.create().run();
    }
}
