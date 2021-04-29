package myexceptions;

@SuppressWarnings("serial")
public class GoingOutOfNumericRangeException extends Exception {
	
	public GoingOutOfNumericRangeException (String message) {
        super(message);
    }
}
