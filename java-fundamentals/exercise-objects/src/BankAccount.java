public class BankAccount {

    private String owner;
    private double balance;

    public BankAccount(double balance, String owner) {
        this.balance = balance;
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (this.balance - amount > 0) {
            this.balance -= amount;
        }
    }
}
