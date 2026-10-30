public class Main {
    public static void main(String[] args) {
        Account[] accounts = {
            new Account("Kavya", 1000),
            new Account("Aarav"),
            new Account("Diya", 2500)
        };

        accounts[0].deposit(500);
        accounts[0].withdraw(200);

        accounts[1].deposit(1200);
        boolean secondWithdrawal = accounts[1].withdraw(300);

        accounts[2].deposit(500);
        boolean thirdWithdrawal = accounts[2].withdraw(4000);

        System.out.println("MINIBANK ACCOUNT SUMMARY");
        System.out.println("------------------------");

        for (Account account : accounts) {
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Owner: " + account.getOwnerName());
            System.out.println("Balance: Rs. " + account.getBalance());
            System.out.println();
        }

        System.out.println("Withdrawal of Rs. 300 from account 2: "
                + (secondWithdrawal ? "Successful" : "Failed"));
        System.out.println("Withdrawal of Rs. 4000 from account 3: "
                + (thirdWithdrawal ? "Successful" : "Failed"));
    }
}
