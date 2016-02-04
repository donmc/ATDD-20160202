package com.tddair;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class WhenMemberBuysUpgradesWithCC
{
	private Member member;
	private String validCCNum;
	private String invalidCCNum;

	@Before
	public void setup()
	{
		member = new Member("bob", "@");
		validCCNum = "1234567890123456";
		invalidCCNum = "0123456789012345";
		CasSpy casSpy = new CasSpy();
		member.setCas(casSpy);
	}

	@Test
	public void shouldDeductMoney_Red()
	{
		member.setStatus(Status.Red);
		
		member.purchaseUpgradesWithCC(1, validCCNum);
		
		assertEquals(100, member.getCas().getAmountCharged());
	}

	@Test
	public void shouldDeductMoney_Green()
	{
		member.setStatus(Status.Green);
		
		member.purchaseUpgradesWithCC(2, validCCNum);
		
		assertEquals(180, member.getCas().getAmountCharged());
	}

	@Test
	public void shouldDeductMoney_Blue()
	{
		member.setStatus(Status.Blue);
		
		member.purchaseUpgradesWithCC(3, validCCNum);
		
		assertEquals(225, member.getCas().getAmountCharged());
	}

	@Test
	public void shouldDeductMoney_Golden()
	{
		member.setStatus(Status.Golden);
		
		member.purchaseUpgradesWithCC(4, validCCNum);
		
		assertEquals(240, member.getCas().getAmountCharged());
	}

	@Test
	public void shouldIncrementAvailableUpgrades()
	{
		member.setSeatUpgrades(0);
		
		member.purchaseUpgradesWithCC(1, validCCNum);
		
		assertEquals(1, member.getSeatUpgrades());
	}
	
	@Test
	public void shouldIncrementAvailableUpgrades_MultipleUpgrades()
	{
		member.setSeatUpgrades(1);
		
		member.purchaseUpgradesWithCC(2, validCCNum);
		
		assertEquals(3, member.getSeatUpgrades());
	}
	
	@Test
	public void shouldErrorWhenInvalidCard()
	{
		member.setStatus(Status.Blue);
		
		try
		{
			member.purchaseUpgradesWithCC(1, invalidCCNum);
			fail("Should throw InvalidCreditCardException");
		}
		catch(InvalidCreditCardException e)
		{
			assertEquals(0, member.getCas().getAmountCharged());
		}
	}
	
	@Test(expected=InsufficientMilesException.class)
	public void shouldErrorWhenInvalidCard_MultipleUpgrades()
	{
		member.setStatus(Status.Green);
		
		try
		{
			member.purchaseUpgradesWithMiles(2);
			fail("Should throw InvalidCreditCardException");
		}
		catch(InvalidCreditCardException e)
		{
			assertEquals(0, member.getCas().getAmountCharged());
		}
	}
}
