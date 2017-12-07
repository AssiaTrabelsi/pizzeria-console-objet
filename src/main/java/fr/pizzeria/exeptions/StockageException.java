package fr.pizzeria.exeptions;

public class StockageException extends Exception {

	String msg;

	public StockageException(String msg) {

		this.msg = msg;

	}

	public String getMessage() {

		return msg;

	}

}
