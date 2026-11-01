import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final List<Account> accounts = new ArrayList<>();
    private static long totalDeposits = 0;
    private static long totalWithdrawals = 0;

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("          WELCOME TO MINI BANK");
        System.out.println("==========================================");
        boolean running = true;
        while (running) {
            showMenu();
            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1 -> createAccount();
                case 2 -> depositMoney();
                case 3 -> withdrawMoney();
                case 4 -> checkBalance();
                case 5 -> {
                    showFinalSummary();
                    System.out.println("Thank you for using Mini Bank. Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Please select 1 to 5.");
            }
        }
        sc.close();
    }

    private static void showMenu() {
        System.out.println("\n============== MAIN MENU ==============");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Check Balance");
        System.out.println("5. Exit");
        System.out.println("=======================================");
    }

    private static void createAccount() {
        System.out.print("Enter account holder name: ");
        String name = sc.nextLine().trim();
        if (name.isEmpty()) { System.out.println("Name cannot be empty."); return; }
        long openingBalance = readLong("Enter opening balance (Rs.): ");
        if (openingBalance < 0) { System.out.println("Opening balance cannot be negative."); return; }
        Account account = new Account(name, openingBalance);
        accounts.add(account);
        System.out.println("Account created successfully!");
        System.out.println("Account Number : " + account.getAccountNumber());
        System.out.println("Account Holder : " + account.getOwnerName());
        System.out.println("Current Balance: Rs. " + account.getBalance());
    }

    private static void depositMoney() {
        Account account = findAccount();
        if (account == null) return;
        long amount = readLong("Enter deposit amount (Rs.): ");
        if (amount <= 0) { System.out.println("Deposit amount must be greater than zero."); return; }
        account.deposit(amount);
        totalDeposits += amount;
        System.out.println("Deposit successful.");
        System.out.println("Updated Balance: Rs. " + account.getBalance());
    }

    private static void withdrawMoney() {
        Account account = findAccount();
        if (account == null) return;
        long amount = readLong("Enter withdrawal amount (Rs.): ");
        if (amount <= 0) { System.out.println("Withdrawal amount must be greater than zero."); return; }
        if (account.withdraw(amount)) {
            totalWithdrawals += amount;
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Withdrawal failed. Insufficient balance.");
        }
        System.out.println("Updated Balance: Rs. " + account.getBalance());
    }

    private static void checkBalance() {
        Account account = findAccount();
        if (account == null) return;
        System.out.println("Account Holder : " + account.getOwnerName());
        System.out.println("Account Number : " + account.getAccountNumber());
        System.out.println("Available Balance: Rs. " + account.getBalance());
    }

    private static Account findAccount() {
        if (accounts.isEmpty()) { System.out.println("No account exists. Please create an account first."); return null; }
        System.out.print("Enter account number: ");
        String number = sc.nextLine().trim();
        for (Account account : accounts) {
            if (account.getAccountNumber().equalsIgnoreCase(number)) return account;
        }
        System.out.println("Account not found. Please check the account number.");
        return null;
    }

    private static void showFinalSummary() {
        System.out.println("\n============= FINAL BANK SUMMARY =============");
        if (accounts.isEmpty()) {
            System.out.println("No accounts were created during this session.");
        } else {
            long totalBalance = 0;
            for (Account account : accounts) {
                totalBalance += account.getBalance();
                System.out.println("\nAccount Number : " + account.getAccountNumber());
                System.out.println("Account Holder : " + account.getOwnerName());
                System.out.println("Final Balance  : Rs. " + account.getBalance());
            }
            System.out.println("\nNumber of Accounts : " + accounts.size());
            System.out.println("Total Current Balance of All Accounts: Rs. " + totalBalance);
        }
        System.out.println("Total Successful Deposits   : Rs. " + totalDeposits);
        System.out.println("Total Successful Withdrawals: Rs. " + totalWithdrawals);
        System.out.println("================================================");
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try { return Integer.parseInt(sc.nextLine().trim()); }
            catch (NumberFormatException e) { System.out.println("Please enter a valid whole number."); }
        }
    }

    private static long readLong(String prompt) {
        while (true) {
            System.out.print(prompt);
            try { return Long.parseLong(sc.nextLine().trim()); }
            catch (NumberFormatException e) { System.out.println("Please enter a valid amount using digits only."); }
        }
    }
}
