package com.tddair;

public class DuplicateUsernameException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7782164149118059932L;

	public DuplicateUsernameException()
	{
		super("Username already exists");
	}

}
