package com.tddair;

public enum Status {
	Red(0, 10000, 100), Green(25000, 9000, 90), Blue(50000, 8000, 75), Gold(75000, 7000, 60);

	private int threshold;
	private int seatUpgradeCostMiles;
	private int seatUpgradeCostDollars;

	private Status(int threshold, int seatUpgradeCostMiles, int seatUpgradeCostDollars) {
		this.threshold = threshold;
		this.seatUpgradeCostMiles = seatUpgradeCostMiles;
		this.seatUpgradeCostDollars = seatUpgradeCostDollars;
	}

	public int getThreshold() {
		return threshold;
	}

	public static Status calculateStatusFor(int ytdMiles) {
		Status status = Red;

		for (Status aStatus : values()) {
			if (aStatus.isMatch(ytdMiles)) {
				status = aStatus;
			}
		}

		return status;
	}

	private boolean isMatch(int ytdMiles) {
		return ytdMiles >= threshold;
	}

	public int getSeatUpgradeCostMiles() {
		return seatUpgradeCostMiles;
	}

	public int getSeatUpgradeCostDollars() {
		return seatUpgradeCostDollars;
	}

}
