package com.muulti.spring.service;

/**
 * @author Julia Häusler-Kun
 * @date 2022/12/07
 *
 *       Calculates the linear distance between two train stations by given
 *       longitude and latitude. Returned distance is rounded to integer value.
 * 
 */

public class DistanceCalculator {
	// Method taking two train stations as parameters
	public static int calculateDistance(TrainStation from, TrainStation to) {
		double d = 0.0;

		try {

			// Getting longitude and latitude from train station and parse to double
			double lonFrom = Double.valueOf(from.getLon().replace(",", "."));
			double latFrom = Double.valueOf(from.getLat().replace(",", "."));
			double lonTo = Double.valueOf(to.getLon().replace(",", "."));
			double latTo = Double.valueOf(to.getLat().replace(",", "."));

			// calculation of distance between the two train stations
			final int RADIUS = 6371;
			double lat = Math.toRadians(latTo - latFrom);
			double lon = Math.toRadians(lonTo - lonFrom);
			double a = Math.sin(lat / 2) * Math.sin(lat / 2) + Math.cos(Math.toRadians(latFrom))
					* Math.cos(Math.toRadians(latTo)) * Math.sin(lon / 2) * Math.sin(lon / 2);
			double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
			d = RADIUS * c;

		} catch (NullPointerException e) {
			e.printStackTrace();
			if (from.getLon() == null) {
				System.out.println(
						"Exception thrown by DistanceCalculator class: from.getLon() is null because from does not exist or is not a FV station");
				
			}
			if (to.getLon() == null) {
				System.out.println(
						"Exception thrown by DistanceCalculator class: to.getLon() is null because to does not exist or is not a FV station");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println(
					"Exception thrown by DistanceCalculator class: Calculation failed because getLon() or getLat() values cannot be converted to double value");
		}
		return (int) Math.abs(d);
	}
}
