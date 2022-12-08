package com.muulti.distancecalculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.muulti.spring.service.TrainStation;

class TrainStationTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void createTrainStation() {
		assertTrue(new TrainStation("BLS").getName().equals("Berlin Hbf"));
		assertFalse(new TrainStation("BLS").getName().equals("BerlinHbf"));
	}

}
