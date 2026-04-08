import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        BankSystem bank = new BankSystem();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1.Bank  2.ATM  3.Admin  4.Array  5.Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("1.Request 2.Deposit 3.Withdraw");
                    int b = sc.nextInt();
                    if (b == 1) {
                        System.out.print("id: ");
                        int id = sc.nextInt();
                        System.out.print("name: ");
                        String name = sc.next();
                        System.out.print("balance: ");
                        double bal = sc.nextDouble();
                        bank.addRequest(id, name, bal);
                    }

                    if (b == 2) {
                        System.out.print("name: ");
                        String name = sc.next();
                        System.out.print("amount: ");
                        double a = sc.nextDouble();
                        bank.deposit(name, a);
                    }

                    if (b == 3) {
                        System.out.print("name: ");
                        String name = sc.next();
                        System.out.print("amount: ");
                        double a = sc.nextDouble();
                        bank.withdraw(name, a);
                    }
                    break;

                case 2:
                    System.out.print("name: ");
                    String name = sc.next();
                    BankAccount acc = bank.findAccount(name);
                    if (acc != null)
                        System.out.println("Balance: " + acc.getBalance());
                    else
                        System.out.println("Account not found");
                    break;

                case 3:
                    System.out.println("1.Process request 2.Add bill 3.Process bill");
                    int a = sc.nextInt();

                    if (a == 1) bank.processRequest();
                    if (a == 2) {
                        System.out.print("bill: ");
                        bank.addBill(sc.next());
                    }
                    if (a == 3) bank.processBill();
                    break;

                case 4:
                    bank.showArrayAccounts();
                    break;
            }

        } while (choice != 5);
    }
}