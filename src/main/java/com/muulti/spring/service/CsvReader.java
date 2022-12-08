package com.muulti.spring.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

import com.muulti.spring.validation.TrainStationVerifier;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

/**
 * @author Julia Häusler-Kun
 * @date 2022/12/07
 *
 *       Reads data from a csv source file (=provided list of train
 *       stations) to a list of beans. The data from the source file is filtered
 *       by a BeanVerifier after creation of beans, but before being passed on.
 * 
 */

public class CsvReader {

	private static final String FILE_PATH = "/Users/julia/eclipse-workspace/distance-calculator/src/main/resources/D_Bahnhof_2020_alle2.CSV";
	private static CsvToBean<TrainStation> csvToBeanReader;

	public static CsvToBean<TrainStation> getCsvToBeanReader() {
		return csvToBeanReader;
	}

	public CsvReader() {
		try {
			// Create list of beans from csv source file
			// TrainStationVerifier filters far distance train stations (FV Fernverkehr)
			Reader reader = new BufferedReader(new FileReader(FILE_PATH));
			csvToBeanReader = new CsvToBeanBuilder<TrainStation>(reader).withSeparator(';').withType(TrainStation.class)
					.withVerifier(new TrainStationVerifier()).withIgnoreLeadingWhiteSpace(true).build();

		} catch (FileNotFoundException e) {
			System.out.println("Exception thrown by CsvReader class: csv file was not found or can not be read");
			e.printStackTrace();
		}
	}

	public void setCsvToBeanReader(Object object) {
		// TODO Auto-generated method stub
		
	}

}
