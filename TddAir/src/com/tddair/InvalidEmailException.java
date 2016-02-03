package com.tddair;

public class InvalidEmailException extends Exception {
	
	public InvalidEmailException()
	{
		super("Email is Invalid!");
	}

}
