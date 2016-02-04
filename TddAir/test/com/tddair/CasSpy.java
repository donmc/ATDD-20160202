package com.tddair;

public class CasSpy implements Cas
{
	private int amountCharged;
	
	public int getAmountCharged()
	{
		return amountCharged;
	}

	@Override
	public void purchase(String ccNum, int cost)
	{
		if(!isValidCreditCardNumber(ccNum))
		{
			throw new InvalidCreditCardException();
		}
		amountCharged = cost;
	}

	private boolean isValidCreditCardNumber(String ccNum)
	{
		if(ccNum == null || ccNum.startsWith("0"))
		{
			return false;
		}
		else return true;
	}
}
