package com.muulti.spring.service;

import java.util.Iterator;

import com.opencsv.bean.CsvBindByName;

/**
 * @author Julia Häusler-Kun
 * @date 2022/12/07
 *
 *       Class for mapping data from csv source file to an object. Csv column
 *       headings are mapped to the instance variables using @CsvBindByName
 *       annotations.
 * 
 */

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

	// Parameterized constructor taking DS100 code as parameter to get data from csv
	// source file creating a new TrainStation instance
	public TrainStation(String code) {
		// Getting data from csv document via CsvReader class
		new CsvReader();

		// Going through list of beans created form csv data to find train station with
		// given DS100 code
		try {
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
					break;
				}
			}
			// if entered DS100 code does not exist in filtered list of beans (e.g. because
			// it is not a FV train station) message is passed on to Distance class that
			// calculation
			// is not possible
			if (!csvTrainStationIterator.hasNext() && this.name == null) {
				this.name = "" + code + " ist kein Fernverkehrbahnhof. "
						+ "Die Distanz kann nur zwischen zwei Fernbahnhöfen berechnet werden.";
			}
		} catch (NullPointerException e) {
			System.out.println("Exception thrown by TrainStation class: No data from CsvReader available");
			e.printStackTrace();

		}
	}

	

	// Getters and setters
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
	
	// ALTERNATIVE IMPLEMENTATION FOR LINE 49 to 79
		// Getting train station form csv source file data by calling parameterized
		// method.
		// This alternative might be useful if Dependency injection is used.

//		// Method taking DS100 code as parameter to get data from csv
//		// source file returning the corresponding train station
//		public static TrainStation getTrainStation(String code) {
	//
//			// Getting data from csv document via CsvReader class
//			new CsvReader();
//			
//			// Going through list of beans created form csv data to find train station with
//			// given DS100 code
//			TrainStation csvTrainStation = null;
//			try {
//				Iterator<TrainStation> csvTrainStationIterator = CsvReader.getCsvToBeanReader().iterator();
//				while (csvTrainStationIterator.hasNext()) {
//					TrainStation tempTrainStation = csvTrainStationIterator.next();
//					if (tempTrainStation.code.equals(code)) {
//						csvTrainStation = tempTrainStation;
//						break;
//					}
//				}
//				// if entered DS100 code does not exist in filtered list of beans (e.g. because
//				// it is not a FV train station) message is passed on to Distance class that
//				// calculation
//				// is not possible
//				if (!csvTrainStationIterator.hasNext() && csvTrainStation == null) {
//					csvTrainStation = new TrainStation();
//					csvTrainStation.name = "" + code + " ist kein Fernverkehrbahnhof. "
//							+ "Die Distanz kann nur zwischen zwei Fernbahnhöfen berechnet werden.";
//				}
//			} catch (NullPointerException e) {
//				System.out.println("Exception thrown by TrainStation class: No data from CsvReader available");
//				e.printStackTrace();
	//
//			}
//			return csvTrainStation;
	//
//		}

}
