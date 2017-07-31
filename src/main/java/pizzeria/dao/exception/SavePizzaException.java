package pizzeria.dao.exception;

public class SavePizzaException extends StockageException {

	public SavePizzaException() {
		super();

	}

	public SavePizzaException(String message, Throwable cause) {
		super(message, cause);

	}

	public SavePizzaException(Throwable cause) {
		super(cause);

	}

	public SavePizzaException(Exception e){
		super(e);
	}


	public SavePizzaException(String string) {
		
	}


}
