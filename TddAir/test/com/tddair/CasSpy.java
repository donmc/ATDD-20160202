package com.tddair;

public class CasSpy implements Cas {

	public static final String INVALID_CC = "11111111111";
	public static final String VALID_CC = "22222222222";
	private int amountCharged;
	
	public int getAmountCharged() {
		return amountCharged;
	}

	@Override
	public boolean purchase(int cost, String ccNum) {
		this.amountCharged = cost;
		return ccNum.equals(VALID_CC);
	}

}
