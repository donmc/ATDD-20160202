package com.tddair;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class WhenPurchasingSeatUpgrades {

		
	@Test
	public void shouldIncreaseSeatUpgradeBalance() {
		Member member = new Member("don", "don@don.com");
		
		member.purchaseSeatUpgrades(1);
		
		assertEquals(1, member.getSeatUpgradeBalance());
	}
	
	@Ignore @Test
	public void shouldDebitCorrectAmount_Red() {
		Member member = new Member("don", "don@don.com");
		
		member.purchaseSeatUpgrades(1);
		
		assertEquals(0, member.getBalanceMiles());
	}

}
