public class Main {
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount("Karnika Gupta", "ITMU2025", 10000.00);
        ATM atmMachine = new ATM(myAccount);
        atmMachine.start();
    }
}