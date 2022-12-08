package com.muulti.distancecalculator;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.muulti.spring.service.DistanceCalculator;
import com.muulti.spring.service.TrainStation;

class DistanceCalculatorTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalculateDistance() {
		assertTrue(DistanceCalculator.calculateDistance(new TrainStation("BLS"),
				new TrainStation("FF")) == 423);
		assertFalse(DistanceCalculator.calculateDistance(new TrainStation("KA"),
				new TrainStation("FF")) == 200);
	}

}
