```java
public class Main {

    public static void main(String[] args) {

        // ==========================================
        // 1. CREATE THREE ACCOUNTS
        // ==========================================
        System.out.println("==========================================");
        System.out.println("       CREATION OF THREE ACCOUNTS");
        System.out.println("==========================================");

        Account account1 = new Account("Kavya", 1000);
        Account account2 = new Account("Aarav", 0);
        Account account3 = new Account("Diya", 2500);

        System.out.println("Account 1 created successfully!");
        System.out.println("Account Number: " + account1.getAccountNumber());
        System.out.println("Owner: " + account1.getOwnerName());
        System.out.println("Opening Balance: Rs. " + account1.getBalance());
        System.out.println();

        System.out.println("Account 2 created successfully!");
        System.out.println("Account Number: " + account2.getAccountNumber());
        System.out.println("Owner: " + account2.getOwnerName());
        System.out.println("Opening Balance: Rs. " + account2.getBalance());
        System.out.println();

        System.out.println("Account 3 created successfully!");
        System.out.println("Account Number: " + account3.getAccountNumber());
        System.out.println("Owner: " + account3.getOwnerName());
        System.out.println("Opening Balance: Rs. " + account3.getBalance());


        // ==========================================
        // 2. DEPOSIT OPERATIONS
        // ==========================================
        System.out.println();
        System.out.println("==========================================");
        System.out.println("          DEPOSIT OPERATIONS");
        System.out.println("==========================================");

        account1.deposit(500);
        System.out.println("Rs. 500 deposited into "
                + account1.getAccountNumber()
                + " successfully.");
        System.out.println("Current Balance: Rs. "
                + account1.getBalance());
        System.out.println();

        account2.deposit(1200);
        System.out.println("Rs. 1200 deposited into "
                + account2.getAccountNumber()
                + " successfully.");
        System.out.println("Current Balance: Rs. "
                + account2.getBalance());
        System.out.println();

        account3.deposit(500);
        System.out.println("Rs. 500 deposited into "
                + account3.getAccountNumber()
                + " successfully.");
        System.out.println("Current Balance: Rs. "
                + account3.getBalance());


        // ==========================================
        // 3. WITHDRAWAL OPERATIONS
        // ==========================================
        System.out.println();
        System.out.println("==========================================");
        System.out.println("         WITHDRAWAL OPERATIONS");
        System.out.println("==========================================");

        boolean withdrawal1 = account1.withdraw(200);

        System.out.println("Withdrawal of Rs. 200 from "
                + account1.getAccountNumber() + ": "
                + (withdrawal1 ? "Successful" : "Failed"));
        System.out.println("Current Balance: Rs. "
                + account1.getBalance());
        System.out.println();

        boolean withdrawal2 = account2.withdraw(300);

        System.out.println("Withdrawal of Rs. 300 from "
                + account2.getAccountNumber() + ": "
                + (withdrawal2 ? "Successful" : "Failed"));
        System.out.println("Current Balance: Rs. "
                + account2.getBalance());
        System.out.println();

        boolean withdrawal3 = account3.withdraw(4000);

        System.out.println("Withdrawal of Rs. 4000 from "
                + account3.getAccountNumber() + ": "
                + (withdrawal3 ? "Successful" : "Failed"));
        System.out.println("Current Balance: Rs. "
                + account3.getBalance());


        // ==========================================
        // 4. FINAL ACCOUNT BALANCES
        // ==========================================
        System.out.println();
        System.out.println("==========================================");
        System.out.println("        FINAL ACCOUNT BALANCES");
        System.out.println("==========================================");

        System.out.println("Account Number : "
                + account1.getAccountNumber());
        System.out.println("Owner          : "
                + account1.getOwnerName());
        System.out.println("Final Balance  : Rs. "
                + account1.getBalance());
        System.out.println();

        System.out.println("Account Number : "
                + account2.getAccountNumber());
        System.out.println("Owner          : "
                + account2.getOwnerName());
        System.out.println("Final Balance  : Rs. "
                + account2.getBalance());
        System.out.println();

        System.out.println("Account Number : "
                + account3.getAccountNumber());
        System.out.println("Owner          : "
                + account3.getOwnerName());
        System.out.println("Final Balance  : Rs. "
                + account3.getBalance());

        System.out.println();
        System.out.println("==========================================");
        System.out.println("       MINI BANK PROGRAM COMPLETED");
        System.out.println("==========================================");
    }
}
```