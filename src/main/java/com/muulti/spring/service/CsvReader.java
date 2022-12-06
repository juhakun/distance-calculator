package com.muulti.spring.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

import com.muulti.spring.validation.TrainStationVerifier;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CsvReader {

	private static final String FILE_PATH = "/Users/julia/eclipse-workspace/distance-calculator/src/main/resources/D_Bahnhof_2020_alle.CSV";
	private static CsvToBean<TrainStation> csvToBeanReader;

	public static CsvToBean<TrainStation> getCsvToBeanReader() {
		return csvToBeanReader;
	}

	public CsvReader() {
		try {
			// Create bean from csv
			// TrainStationVerifier filters far distance train stations (FV Fernverkehr)
			// before creating beans
			System.out.println(FILE_PATH);
			Reader reader = new BufferedReader(new FileReader(FILE_PATH));
			csvToBeanReader = new CsvToBeanBuilder<TrainStation>(reader).withSeparator(';').withType(TrainStation.class)
					.withVerifier(new TrainStationVerifier()).withIgnoreLeadingWhiteSpace(true).build();

		} catch (FileNotFoundException e) {
			System.out.println("File was not found");
			e.printStackTrace();
		}

	}

}
