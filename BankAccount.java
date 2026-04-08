public class BankAccount {
    private int accountNumber;
    private String username;
    private double balance;

    public BankAccount(int accountNumber, String username, double balance) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.balance = balance;
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public String getUsername() {
        return username;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        balance += amount;
    }
    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Not enough balance!");
            return false;
        }
    }
    public void display() {
        System.out.println(username + " – Balance: " + balance);
    }
}