package com.muulti.spring.service;

public class DistanceCalculator {

	private int distance;

	public int getDistance() {
		return distance;
	}

	public DistanceCalculator() {

	}

	public DistanceCalculator(TrainStation from, TrainStation to) {
		try {
			// get lon and lat from train station and parse to double
			double lonFrom = Double.valueOf(from.getLon().replace(",", "."));
			double latFrom = Double.valueOf(from.getLat().replace(",", "."));
			double lonTo = Double.valueOf(to.getLon().replace(",", "."));
			double latTo = Double.valueOf(to.getLat().replace(",", "."));

			final int RADIUS = 6371;

			// calculate distance
			double lat = Math.toRadians(latTo - latFrom);
			double lon = Math.toRadians(lonTo - lonFrom);
			double a = Math.sin(lat / 2) * Math.sin(lat / 2) + Math.cos(Math.toRadians(latFrom))
					* Math.cos(Math.toRadians(latTo)) * Math.sin(lon / 2) * Math.sin(lon / 2);
			double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
			double d = RADIUS * c;

			this.distance = (int) Math.abs(d);
		} catch (NullPointerException e) {
			if (from.getLon() == null) {
					System.out.println("from is not a FV station"); 
			}
			if (to.getLon() == null) {
				System.out.println("from is not a FV station");
			}
		}

	}
}
