package exceptions;

public class SameIdException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SameIdException() {
		super("Already existing id");
	}

}
