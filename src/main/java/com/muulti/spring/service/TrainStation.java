package com.muulti.spring.service;

import java.util.Iterator;

import com.opencsv.bean.CsvBindByName;

public class TrainStation {

	@CsvBindByName(column = "EVA_NR")
	private int evaNr;

	@CsvBindByName(column = "DS100")
	private String code;

	@CsvBindByName(column = "IFOPT")
	private String ifopt;

	@CsvBindByName(column = "NAME")
	private String name;

	@CsvBindByName(column = "Verkehr")
	private String traffic;

	@CsvBindByName(column = "Laenge")
	private String lon;

	@CsvBindByName(column = "Breite")
	private String lat;

	@CsvBindByName(column = "Betreiber_Name")
	private String operatorName;

	@CsvBindByName(column = "Betreiber_Nr")
	private int operatorNr;

	@CsvBindByName(column = "Status")
	private String status;

	public int getEvaNr() {
		return evaNr;
	}

	public String getCode() {
		return code;
	}

	public String getIfopt() {
		return ifopt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTraffic() {
		return traffic;
	}

	public String getLon() {
		return lon;
	}

	public String getLat() {
		return lat;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public int getOperatorNr() {
		return operatorNr;
	}

	public String getStatus() {
		return status;

	}

	public TrainStation() {

	}

	public TrainStation(String code) {
		// Get data from csv document via reader class
		new CsvReader();

		// Go through each line of csv data and find train station with given DS100
		// code
		Iterator<TrainStation> csvTrainStationIterator = CsvReader.getCsvToBeanReader().iterator();
		while (csvTrainStationIterator.hasNext()) {
			TrainStation csvTrainStation = csvTrainStationIterator.next();
			if (csvTrainStation.code.equals(code)) {
				this.evaNr = csvTrainStation.getEvaNr();
				this.code = csvTrainStation.getCode();
				this.name = csvTrainStation.getName();
				this.ifopt = this.traffic = csvTrainStation.traffic;
				this.lon = csvTrainStation.lon;
				this.lat = csvTrainStation.lat;
				this.operatorName = csvTrainStation.operatorName;
				this.operatorNr = csvTrainStation.operatorNr;
				this.status = csvTrainStation.status;
				return;
			}
		}
		if (!csvTrainStationIterator.hasNext() && this.name == null) {
			this.name = "" + code + " ist kein Fernverkehrbahnhof. "
					+ "Die Distanz kann nur zwischen zwei Fernbahnhöfen berechnet werden.";
		}

	}

}
