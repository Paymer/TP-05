package dev.exception;

public class SavePizzaException extends StockageException {

	public SavePizzaException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SavePizzaException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public SavePizzaException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public SavePizzaException(Exception e){
		super(e);
	}

	public SavePizzaException(String string, Exception e) {
		super(e);
	}

	public SavePizzaException(String string) {
		
	}


}
