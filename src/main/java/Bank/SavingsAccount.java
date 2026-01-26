package Bank;

import Exceptions.InvalidAmount;
import Exceptions.MaxBalance;
import Exceptions.MaxWithdraw;

public class SavingsAccount extends BankAccount {

    public SavingsAccount(String name, double balance, double min_balance) throws Exception {
        super(name, balance, min_balance);
    }

    public void transfer(BankAccount target, double amount) throws InvalidAmount, MaxBalance, MaxWithdraw {
        if (amount <= 0) {
            throw new InvalidAmount("Transfer amount must be greater than zero.");
        }
        if (getBalance() - amount < getMinBalance()) {
            throw new MaxBalance("Insufficient balance for transfer.");
        }

        // Withdraw from this account
        withdraw(amount);
        // Deposit to target
        target.deposit(amount);
    }
}

