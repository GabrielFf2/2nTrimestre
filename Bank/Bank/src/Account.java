import java.time.LocalDateTime;
import java.util.ArrayList;
public abstract class Account {

    protected int accountNumber;
    protected double balance;
    protected Client owner;

    private ArrayList<Transaction> transactions;

    public Account(int accountNumber, double balance, Client owner) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.owner = owner;

        this.transactions = new ArrayList<Transaction>();
    }

    public abstract void deposit(double amount) throws InvalidDepositException;

    public abstract void withdraw(double amount) throws InvalidWithdrawException;

    public void confirmDeposit(double amount) {
        this.balance += amount;
        this.transactions.add(new Transaction(LocalDateTime.now(), amount, this.balance, TransactionType.DEPOSIT));
    }

    public void confirmWithdraw(double amount) {
        this.balance -= amount;
        this.transactions.add(new Transaction(LocalDateTime.now(), amount, this.balance, TransactionType.WITHDRAWAL));
    }

    public abstract void viewAccount();

    @Override
    public String toString() {
        return "[accountNumber=" + this.accountNumber + ", owner=" + this.owner.fullName() + "]";
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    protected String viewTransactions() {
        String s = "";
        for (Transaction transaction : transactions) {
            s += transaction.toString() + "\n";
        }
        return s;
    }

}