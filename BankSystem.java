import java.util.*;

public class BankSystem {

    LinkedList<BankAccount> accounts = new LinkedList<>();
    Stack<String> history = new Stack<>();
    Queue<String> billQueue = new LinkedList<>();
    Queue<BankAccount> accountRequests = new LinkedList<>();
    BankAccount[] fixedAccounts = new BankAccount[3];

    public BankSystem() {
        fixedAccounts[0] = new BankAccount(100, "Aruzhan", 50000);
        fixedAccounts[1] = new BankAccount(101, "Dias", 70000);
        fixedAccounts[2] = new BankAccount(102, "Alina", 90000);
    }

    // Task 1
    public void addAccount(int id, String username, double balance) {
        accounts.add(new BankAccount(id, username, balance));
        System.out.println("Account added");
    }

    public void displayAccounts() {
        for (BankAccount acc : accounts) {
            acc.display();
        }
    }

    public BankAccount findAccount(String username) {
        for (BankAccount acc : accounts) {
            if (acc.getUsername().equalsIgnoreCase(username)) {
                return acc;
            }
        }
        return null;
    }

    // Task 2
    public void deposit(String user, double amount) {
        BankAccount acc = findAccount(user);
        if (acc != null) {
            acc.deposit(amount);
            history.push("Deposit " + amount + " to " + user);
            System.out.println("New balance: " + acc.getBalance());
        } else {
            System.out.println("Account not found");
        }
    }

    public void withdraw(String user, double amount) {
        BankAccount acc = findAccount(user);
        if (acc != null && acc.withdraw(amount)) {
            history.push("Withdraw " + amount + " from " + user);
            System.out.println("New balance: " + acc.getBalance());
        } else {
            System.out.println("Account not found or insufficient balance");
        }
    }

    // Task 3
    public void showLastTransaction() {
        if (!history.isEmpty())
            System.out.println("Last: " + history.peek());
    }

    public void undo() {
        if (!history.isEmpty())
            System.out.println("Undo: " + history.pop());
    }

    // Task 4
    public void addBill(String bill) {
        billQueue.add(bill);
        System.out.println("Added: " + bill);
    }

    public void processBill() {
        if (!billQueue.isEmpty())
            System.out.println("Processing: " + billQueue.poll());
    }

    // Task 5
    public void addRequest(int id, String user, double bal) {
        accountRequests.add(new BankAccount(id, user, bal));
        System.out.println("Request added");
    }

    public void processRequest() {
        if (!accountRequests.isEmpty()) {
            BankAccount acc = accountRequests.poll();
            accounts.add(acc);
            System.out.println("Account created: " + acc.getUsername());
        }
    }

    // Task 6
    public void showArrayAccounts() {
        System.out.println("Fixed accounts:");
        for (BankAccount acc : fixedAccounts) {
            acc.display();
        }
    }
}