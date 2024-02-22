public class InvalidWithdrawException extends Exception {

    public InvalidWithdrawException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "ERROR: Withdraw couldn't be processed, " + getMessage();
    }

}