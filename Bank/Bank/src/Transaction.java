import java.time.LocalDate;
import java.time.LocalDateTime;

public class Transaction {

    private LocalDateTime dateTime;
    private TransactionType type;
    private double amount;
    private double finalBalance;
    public static enum TransactionType {
        DEPOSIT,
        WITHDRAWAL
    }

    private void setDateTime(){
        this.dateTime = LocalDateTime.now();
    }
    public Transaction(TransactionType type,double amount ,double finalBalance){
        this.setDateTime();
        this.type=type;
        this.amount=amount;
        this.finalBalance=finalBalance;
    }
    public String viewTransaction(){
        return type.toString() +"[" + "Date = "+ dateTime.getDayOfMonth() +", Time = "+ dateTime.getHour()+":"+dateTime.getMinute()
                + ":"+dateTime.getSecond() + ", Amount = "+ this.amount + ", Balance = " + this.finalBalance + "]";
    }
}
