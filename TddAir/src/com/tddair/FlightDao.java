package com.tddair;

public interface FlightDao
{
	public abstract Flight getFlightBy(String flightNumber);

	public abstract void addFlight(String origin, String destination,
			int mileage, String airline, int number);
}