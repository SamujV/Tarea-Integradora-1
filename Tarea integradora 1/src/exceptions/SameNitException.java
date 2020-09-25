package exceptions;

public class SameNitException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SameNitException() {
		super("Already existing nit");
	}
}
