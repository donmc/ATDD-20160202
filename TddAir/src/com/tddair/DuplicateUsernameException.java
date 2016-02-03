package com.tddair;

public class DuplicateUsernameException extends Exception {
	
	public DuplicateUsernameException()
	{
		super("Username already exists");
	}

}
