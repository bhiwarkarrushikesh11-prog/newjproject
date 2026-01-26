package Bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<BankAccount> accounts = new ArrayList<>();

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public BankAccount findAccount(String accNum) {
        for (BankAccount account : accounts) {
            if (account.getAccNum().equals(accNum)) {
                return account;
            }
        }
        return null;
    }

    public void printBalances() {
        for (BankAccount temp : accounts) {
            // Use getter instead of direct access
            System.out.println("Account: " + temp.getAccNum() + " Balance: " + temp.getBalance());
        }
    }
}

