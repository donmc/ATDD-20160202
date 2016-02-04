package com.tddair;

public enum Status {
	Red(0), Green(25000), Blue(50000), Gold(75000);

	private int threshold;

	private Status(int threshold) {
		this.threshold = threshold;
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

}
