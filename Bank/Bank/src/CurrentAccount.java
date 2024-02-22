public class CurrentAccount extends Account {
    public CurrentAccount(int accountNumber, Client owner) {
        super(accountNumber, 0, owner);
    }

    @Override
    public void viewAccount() {
        String s = "";
        s += "Account Number: " + this.accountNumber + " - CURRENT ACCOUNT\n";
        s += "Owner: " + this.owner.fullName() + ", address at " + this.owner.fullAddress() + "\n";
        s += "Current balance: " + this.balance + "$\n";
        s += "------------------------ TRANSACTIONS ------------------------\n";
        s += this.viewTransactions();
        Borders.printTextWithBorders(s);
    }

    @Override
    public void withdraw(double amount) throws InvalidWithdrawException {
        if (amount > 300) {
            throw new InvalidWithdrawException("max. withdraw 300$");
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
        return "CurrentAccount " + super.toString();
    }

}
