package com.tddair;

public class InvalidEmailException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6206979301561203548L;

	public InvalidEmailException()
	{
		super("Email is Invalid!");
	}

}
