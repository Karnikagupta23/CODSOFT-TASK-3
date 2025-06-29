import java.util.Scanner;

public class ATM {
    private BankAccount userAccount;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.userAccount = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("\n===== Welcome to ATM =====");
        boolean running = true;

        while (running) {
            showMenu();
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    checkBalance();
                    break;
                case "2":
                    performDeposit();
                    break;
                case "3":
                    performWithdrawal();
                    break;
                case "4":
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select from 1 to 4.");
            }
        }
    }

    private void showMenu() {
        System.out.println("\nSelect an operation:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
    }

    private void checkBalance() {
        System.out.printf("Current balance: ₹%.2f\n", userAccount.getBalance());
    }

    private void performDeposit() {
        System.out.print("Enter amount to deposit: ₹");
        try {
            double amount = Double.parseDouble(scanner.nextLine());
            if (userAccount.deposit(amount)) {
                System.out.printf("Successfully deposited ₹%.2f\n", amount);
            } else {
                System.out.println("Deposit amount must be greater than 0.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }

    private void performWithdrawal() {
        System.out.print("Enter amount to withdraw: ₹");
        try {
            double amount = Double.parseDouble(scanner.nextLine());
            if (userAccount.withdraw(amount)) {
                System.out.printf("Successfully withdrawn ₹%.2f\n", amount);
            } else {
                System.out.println("Withdrawal failed. Either amount is invalid or insufficient balance.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }
}