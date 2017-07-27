package pizzeria.dao.exception;

public class CodeRepeteException extends SavePizzaException {

	public CodeRepeteException(String string, Exception e) {
		
		
		super(string, e);
	}

	public CodeRepeteException(String string) {
		super(string);
	
	}

	public CodeRepeteException(Exception msg) {
		super(msg);
	}

}
