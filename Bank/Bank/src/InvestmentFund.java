public class InvestmentFund extends Account {
    private double interest;

    public InvestmentFund(int accountNumber, Client owner) {
        super(accountNumber, 5000, owner);
        this.calculateInterest();
    }

    public double getInterest() {
        return this.interest;
    }

    @Override
    public void viewAccount() {
        String s = "";
        s += "Account Number: " + this.accountNumber + " - INVESTMENT FUND AT " + this.interest + "%\n";
        s += "Owner: " + this.owner.fullName() + ", address at " + this.owner.fullAddress() + "\n";
        s += "Current balance: " + this.balance + "$\n";
        s += "------------------------ TRANSACTIONS ------------------------\n";
        s += this.viewTransactions();
        Borders.printTextWithBorders(s);
    }

    private void calculateInterest() {
        if (this.balance >= 100_000) {
            this.interest = 5;
        } else if (this.balance >= 50_000) {
            this.interest = 4;
        } else {
            this.interest = 2;
        }
    }

    @Override
    public void withdraw(double amount) throws InvalidWithdrawException {
        if (amount > 500) {
            throw new InvalidWithdrawException("max. withdraw 500$");
        }
        if (this.balance - amount < 3000) {
            throw new InvalidWithdrawException("balance after withdraw can't be less than 3000$");
        }
        if (amount <= 0) {
            throw new InvalidWithdrawException("can't withdraw negative amount");
        }
        if (amount > this.balance) {
            throw new InvalidWithdrawException("not enough money");
        }
        this.confirmWithdraw(amount);
        this.calculateInterest();
    }

    @Override
    public void deposit(double amount) throws InvalidDepositException {
        if (amount < 500) {
            throw new InvalidDepositException("min. 500$");
        }
        this.confirmDeposit(amount);
        this.calculateInterest();
    }

    @Override
    public String toString() {
        return "InvestmentFund " + super.toString();
    }

}
