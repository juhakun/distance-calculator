package com.muulti.spring.validation;

import com.muulti.spring.service.TrainStation;
import com.opencsv.bean.BeanVerifier;
import com.opencsv.exceptions.CsvConstraintViolationException;

/**
 * @author Julia Häusler-Kun
 * @date 2022/12/07
 *
 *       Class defines filters for creation of beans from data from the source
 *       file.
 * 
 */

public class TrainStationVerifier implements BeanVerifier<TrainStation> {

	@Override
	public boolean verifyBean(TrainStation bean) throws CsvConstraintViolationException {
		// filters all train stations that are not far distance (FV Fernverkehr)
		if (!bean.getTraffic().equals("FV")) {
			return false;
		} else {
			return true;
		}
	}

}
