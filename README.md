# Term Work 2026 – Java Practicals and MiniBank

## MiniBank (interactive)
The MiniBank program is input-driven and shows this menu:
1. Create Account
2. Deposit Money
3. Withdraw Money
4. Check Balance
5. Exit

After creating an account, use its generated account number (for example, AC0001) for deposits, withdrawals, and balance enquiries. On exit, the program displays each account's final balance, the total current balance across all accounts, and the total successful deposits and withdrawals.

Run from `Mini-Bank-Project/src`:
```bash
javac Account.java Main.java
java Main
```

## Practicals
Each practical uses its own Java package to prevent class-name collisions. Public class filenames match their class names. For example, compile Practical 01 from the project root:
```bash
javac -d out Practicals/Practical_01/*.java
java -cp out Practicals.Practical_01.VendingMachine
```
Use the public class name shown in each `.java` filename to run another program. JDK 17 or newer is recommended.
