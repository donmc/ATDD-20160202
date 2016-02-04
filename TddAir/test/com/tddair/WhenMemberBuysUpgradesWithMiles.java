package com.tddair;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class WhenMemberBuysUpgradesWithMiles
{
	private Member member;

	@Before
	public void setup()
	{
		member = new Member("bob", "@");
	}

	@Test
	public void shouldDeductBalanceMiles_Red()
	{
		member.setStatus(Status.Red);
		member.setBalanceMiles(15000);
		
		member.purchaseUpgradesWithMiles(1);
		
		assertEquals(5000, member.getBalanceMiles());
	}

	@Test
	public void shouldDeductBalanceMiles_Green()
	{
		member.setStatus(Status.Green);
		member.setBalanceMiles(25000);
		
		member.purchaseUpgradesWithMiles(2);
		
		assertEquals(7000, member.getBalanceMiles());
	}

	@Test
	public void shouldDeductBalanceMiles_Blue()
	{
		member.setStatus(Status.Blue);
		member.setBalanceMiles(70000);
		
		member.purchaseUpgradesWithMiles(3);
		
		assertEquals(46000, member.getBalanceMiles());
	}

	@Test
	public void shouldDeductBalanceMiles_Golden()
	{
		member.setStatus(Status.Golden);
		member.setBalanceMiles(50000);
		
		member.purchaseUpgradesWithMiles(4);
		
		assertEquals(22000, member.getBalanceMiles());
	}

	@Test
	public void shouldIncrementAvailableUpgrades()
	{
		member.setSeatUpgrades(0);
		
		member.purchaseUpgradesWithMiles(1);
		
		assertEquals(1, member.getSeatUpgrades());
	}
	
	@Test
	public void shouldIncrementAvailableUpgrades_MultipleUpgrades()
	{
		member.setSeatUpgrades(1);
		member.setBalanceMiles(100000);
		
		member.purchaseUpgradesWithMiles(2);
		
		assertEquals(3, member.getSeatUpgrades());
	}
	
	@Test(expected=InsufficientMilesException.class)
	public void shouldErrorWhenNotEnoughMiles()
	{
		member.setStatus(Status.Blue);
		member.setBalanceMiles(7000);
		
		member.purchaseUpgradesWithMiles(1);
	}
	
	@Test(expected=InsufficientMilesException.class)
	public void shouldErrorWhenNotEnoughMiles_MultipleUpgrades()
	{
		member.setStatus(Status.Green);
		member.setBalanceMiles(15000);
		
		member.purchaseUpgradesWithMiles(2);
	}
}
