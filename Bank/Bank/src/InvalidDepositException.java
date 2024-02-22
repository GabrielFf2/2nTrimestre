public class InvalidDepositException extends Exception {
    public InvalidDepositException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "ERROR: Deposit couldn't be processed, " + getMessage();
    }

}
