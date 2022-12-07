package com.muulti.spring.service;

/**
 * @author Julia Häusler-Kun
 * @date 2022/12/07
 *
 *       Resource representation class for JSON response.
 * 
 */

public class Distance {

	// Instantiation of fields for JSON response
	private String from;
	private String to;
	private int distance;
	private String unit = "km";

	// Parameterized constructor receiving two DS100 codes from the controller class
	public Distance(String codeFrom, String codeTo) {
		// Declaration of instance variables by calling in TrainStation and
		// DistanceCalculator class
		this.from = TrainStation.getTrainStation(codeFrom).getName();
		this.to = TrainStation.getTrainStation(codeTo).getName();
		this.distance = DistanceCalculator.calculateDistance(TrainStation.getTrainStation(codeFrom),
				TrainStation.getTrainStation(codeTo));
	}

	// Getters and setters
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	// ALTERNATIVE IMPLEMENTATION FOR LINE 19 to 27
	// Declaration of instance variables by creating two TrainStation objects
	// instead of declaring them like implemented in line 19 to 27.
	// This alternative might be useful if TrainStation objects are needed for
	// further operations.

//	 private transient TrainStation trainStationFrom;
//		private transient TrainStation trainStationTo;	
//	
//		public Distance(String codeFrom, String codeTo) {
//			this.trainStationFrom = new TrainStation(codeFrom);
//			this.trainStationTo = new TrainStation(codeTo);
//			this.from = trainStationFrom.getName();
//			this.to = trainStationTo.getName();
//			this.distance = DistanceCalculator.calculateDistance(trainStationFrom, trainStationTo);
//		}

}
