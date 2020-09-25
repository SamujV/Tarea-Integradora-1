package exceptions;

public class WrongOptionException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WrongOptionException() {
		super("Insert a valid option");
	}

}
