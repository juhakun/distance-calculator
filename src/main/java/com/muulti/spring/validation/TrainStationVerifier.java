package com.muulti.spring.validation;

import com.muulti.spring.service.TrainStation;
import com.opencsv.bean.BeanVerifier;
import com.opencsv.exceptions.CsvConstraintViolationException;

public class TrainStationVerifier implements BeanVerifier<TrainStation> {

	@Override
	public boolean verifyBean(TrainStation bean) throws CsvConstraintViolationException {
		// filter all train stations that are not far distance (FV Fernverkehr)
		if (!bean.getTraffic().equals("FV")) {
			return false;
		} else {
			return true;
		}
	}

}
