package Bank;

public class StudentAccount extends BankAccount {

    public StudentAccount(String name, double balance, double min_balance) throws Exception {
        super(name, balance, min_balance);
    }

    public void printMinBalance() {
        // Use getter instead of direct access
        System.out.println("Minimum balance: " + getMinBalance());
    }
}

