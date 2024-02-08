import java.util.ArrayList;
import java.util.Scanner;

public class Account {

    ArrayList<Transaction>transactions = new ArrayList<Transaction>();
    private static int accountNumberCount = 0;
    private int accountNumber;
    private double balance = 0;
    private Client client ;

    public double getBalance() {
        return balance;
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    public Client getClient() {
        return client;
    }

    public void deposit (double amount){
        balance+=amount;
        Transaction temp = new Transaction(Transaction.TransactionType.DEPOSIT,amount ,this.balance);
        transactions.add(temp);
    }
    public void whithdraw (double amount){
        balance-=amount;
        Transaction temp = new Transaction(Transaction.TransactionType.WITHDRAWAL,amount ,this.balance);
        transactions.add(temp);
    }

    public Account(Client client){
        this.client = client;
        accountNumber = accountNumberCount;
        accountNumberCount++;
    };

    @Override
    public String toString() {
        return "Account{" + "accountNumber=" + accountNumber + ", balance=" + balance + ", client=" + client.fullName() + '}';
    }

    public String viewAccount (){
        String a = "Account{\n AccountNumber=" + accountNumber +" Owner " + client.fullName() +"}";
        for (Transaction trans:transactions) {
            a += "\n" + trans.viewTransaction();
        }
        return a;
    }

}
