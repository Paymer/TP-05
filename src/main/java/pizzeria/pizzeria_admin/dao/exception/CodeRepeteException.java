package pizzeria.pizzeria_admin.dao.exception;

public class CodeRepeteException extends SavePizzaException {

	public CodeRepeteException(String string, Exception e) {
		super(string, e);
		// TODO Auto-generated constructor stub
	}

	public CodeRepeteException(String string) {
		super(string);
		// TODO Auto-generated constructor stub
	}

	public CodeRepeteException(Exception msg) {
		super(msg);
	}

}
