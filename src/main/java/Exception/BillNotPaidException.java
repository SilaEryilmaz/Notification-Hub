package Exception;

public class BillNotPaidException extends RuntimeException {
    public BillNotPaidException(String Message){
        super(Message);
    }
}

