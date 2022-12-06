package com.muulti.spring.service;

public class Distance {

	private String from;
	private String to;
	private int distance;
	private String unit = "km";
	
	private transient TrainStation trainStationFrom;
	private transient TrainStation trainStationTo;
	private transient DistanceCalculator distanceCalculator;

	public Distance(String codeFrom, String codeTo) {
		this.trainStationFrom = new TrainStation(codeFrom);
		this.trainStationTo = new TrainStation(codeTo);
		this.from = trainStationFrom.getName();
		this.to = trainStationTo.getName();
		this.distanceCalculator = new DistanceCalculator(trainStationFrom, trainStationTo);
		this.distance = distanceCalculator.getDistance();
	}

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

}
