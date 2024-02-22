public class MortgageAccount extends Account {

    public MortgageAccount(int accountNumber, Client owner) {
        super(accountNumber, 1000, owner);
    }

    @Override
    public void viewAccount() {
        String s = "";
        s += "Account Number: " + this.accountNumber + " - MORTGAGE ACCOUNT\n";
        s += "Owner: " + this.owner.fullName() + ", address at " + this.owner.fullAddress() + "\n";
        s += "Current balance: " + this.balance + "$\n";
        s += "------------------------ TRANSACTIONS ------------------------\n";
        s += this.viewTransactions();
        Borders.printTextWithBorders(s);
    }

    @Override
    public void withdraw(double amount) throws InvalidWithdrawException {
        if (amount > 500) {
            throw new InvalidWithdrawException("max. withdraw 500$");
        }
        if (amount <= 0) {
            throw new InvalidWithdrawException("can't withdraw negative amount");
        }
        if (amount > this.balance) {
            throw new InvalidWithdrawException("not enough money");
        }
        this.confirmWithdraw(amount);
    }

    @Override
    public void deposit(double amount) throws InvalidDepositException {
        if (amount < 10) {
            throw new InvalidDepositException("min. 10$");
        }
        this.confirmDeposit(amount);
    }

    @Override
    public String toString() {
        return "MortgageAccount " + super.toString();
    }

}
