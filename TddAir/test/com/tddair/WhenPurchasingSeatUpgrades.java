package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WhenPurchasingSeatUpgrades {
	
	private TestMemberMother members = new TestMemberMother();
	
	@Before
	public void setup() {
	}
		
	@Test
	public void shouldIncreaseSeatUpgradeBalance() {
		Member redGuy = members.getRedGuy();
		redGuy.purchaseSeatUpgrades(1);
		
		assertEquals(1, redGuy.getSeatUpgradeBalance());
	}
	
	@Test
	public void shouldDebitCorrectAmountOfMiles_Red() {
		Member redGuy = members.getRedGuy();
		redGuy.purchaseSeatUpgrades(1);
		
		assertEquals(0, redGuy.getBalanceMiles());
	}
	
	@Test
	public void shouldPurchaseMultipleSeatUpgrades() {
		Member member = members.getGreenGuy();
		member.purchaseSeatUpgrades(3);
		
		assertEquals(3, member.getSeatUpgradeBalance());
		assertEquals(8000, member.getBalanceMiles());
	}
	
	@Test
	public void shouldNotPurchaseMultipleSeatUpgradesWhenBroke() {
		Member member = members.getRedGuy();
		member.purchaseSeatUpgrades(2);
		
		assertEquals(0, member.getSeatUpgradeBalance());
		assertEquals(10000, member.getBalanceMiles());
	}
	
	@Test
	public void shouldDebitCorrectAmountOfMiles_Green() {
		Member member = members.getGreenGuy();
		int startBlance =  member.getBalanceMiles();
		member.purchaseSeatUpgrades(1);
		int deltaBalance = startBlance - member.getBalanceMiles();
		
		assertEquals(9000, deltaBalance);
	}
	
	
	@Test
	public void shouldDebitCorrectAmountOfMiles_Blue() {
		Member member = members.getBlueGuy();
		int startBlance =  member.getBalanceMiles();
		member.purchaseSeatUpgrades(1);
		int deltaBalance = startBlance - member.getBalanceMiles();
		
		assertEquals(8000, deltaBalance);
	}
	
	
	@Test
	public void shouldDebitCorrectAmountOfMiles_Gold() {
		Member member = members.getGoldGuy();
		int startBlance =  member.getBalanceMiles();
		member.purchaseSeatUpgrades(1);
		int deltaBalance = startBlance - member.getBalanceMiles();
		
		assertEquals(7000, deltaBalance);
	}
	
	@Test
	public void shouldNotPurchaseSeatUpgradeWithoutEnoughMiles() {
		Member member = members.getRedGuy();
		
		member.purchaseSeatUpgrades(1);
		member.purchaseSeatUpgrades(1);

		assertEquals(1, member.getSeatUpgradeBalance());
		assertEquals(0, member.getBalanceMiles());
	}
	
	@Test
	public void shouldPurchaseSeatUpgradesWithCreditCard () {
		Member member = members.getRedGuy();
		CasSpy casSpy = new CasSpy();
		member.setCas(casSpy);
		int quantity = 2;
		
		boolean isValid = member.purchaseSeatUpgradesWithCC(quantity, CasSpy.VALID_CC);
		
		assertTrue(isValid);
		assertEquals(2, member.getSeatUpgradeBalance());
		assertEquals(200, casSpy.getAmountCharged());
	}
	
	@Test
	public void shouldNotPurchaseSeatUpgradesWithInvalidCreditCard () {
		Member member = members.getRedGuy();
		CasSpy casSpy = new CasSpy();
		member.setCas(casSpy);
		int quantity = 2;
		
		boolean isValid = member.purchaseSeatUpgradesWithCC(quantity, CasSpy.INVALID_CC);
		
		assertFalse(isValid);
		assertEquals(0, member.getSeatUpgradeBalance());
	}

}







