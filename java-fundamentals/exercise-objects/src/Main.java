public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        Car car1 = new Car("Ford", "Crown Victoria", 1997);
        Car car3 = new Car("Ford", "Crown Victoria", 1997);

        System.out.println(car1.displayInfo());
        System.out.println(car1.equals(car3));

        System.out.println("--Books--");

        Book book1 = new Book("The Hobbit", "JRR Tolkein");
        Book book2 = new Book("The Silmarillion", "JRR Tolkein", false);

        System.out.println(book1.isAvailable);
        book1.borrowBook();

        if (book1.isAvailable) {
            book1.borrowBook();
        } else {
            System.out.println("Book unavailable");
        }

        System.out.println("--Bank Account--");
        BankAccount account1 = new BankAccount(99999.00, "Spencer");
        BankAccount account2 = account1;

        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());
        account1.withdraw(10000);
        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());

    }
}