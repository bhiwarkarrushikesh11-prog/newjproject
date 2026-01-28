package Bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Bank {
    private List<BankAccount> accounts = new ArrayList<>();

    // Add new account
    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    // Find account by number
    public BankAccount findAccount(String accNum) {
        for (BankAccount account : accounts) {
            if (account.getAccNum().equals(accNum)) {
                return account;
            }
        }
        return null;
    }

    // Deposit
    public void deposit(String accNum, double amt) {
        BankAccount acc = findAccount(accNum);
        if (acc != null) {
            acc.deposit(amt);
        }
    }

    // Withdraw
    public void withdraw(String accNum, double amt) {
        BankAccount acc = findAccount(accNum);
        if (acc != null) {
            acc.withdraw(amt);
        }
    }

    // Display all accounts as Vector (for DisplayList)
    public Vector<String> display() {
        Vector<String> v = new Vector<>();
        for (BankAccount acc : accounts) {
            v.add(acc.toString());
        }
        return v;
    }

    // Print balances (existing)
    public void printBalances() {
        for (BankAccount temp : accounts) {
            System.out.println("Account: " + temp.getAccNum() + " Balance: " + temp.getBalance());
        }
    }
}
