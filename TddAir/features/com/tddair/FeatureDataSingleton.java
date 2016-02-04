package com.tddair;

public class FeatureDataSingleton {

	private TddAirApplication app = new TddAirApplication();
	private Member member;
	private String errorMessage;
	
	private FeatureDataSingleton() {}
	
	private static class SingletonHolder {
		public static final FeatureDataSingleton INSTANCE = new FeatureDataSingleton();
	}
	
	static FeatureDataSingleton getInstance()
	{
		return SingletonHolder.INSTANCE;
	}

	public TddAirApplication getApp() {
		return app;
	}

	public Member getMember() {
		return member;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String message) {
		errorMessage = message;
	}

	public void setMember(Member lookupMember) {
		member = lookupMember;
	}
	
	
}
