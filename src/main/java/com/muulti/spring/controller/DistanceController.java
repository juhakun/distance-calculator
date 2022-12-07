package com.muulti.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.muulti.spring.service.Distance;

/**
 * @author Julia Häusler-Kun
 * @date 2022/12/07
 *
 *       Controller class handles HTTP requests for mapped method getDistance() by returning a
 *       new instance of Distance class
 * 
 */

@RestController
public class DistanceController {

	// GET request takes two parameters {codeFrom} and {codeTo} representing the
	// DS100 code of a train station
	@GetMapping(value = "/api/v1/distance/{codeFrom}/{codeTo}")
	public Distance getDistance(@PathVariable String codeFrom, @PathVariable String codeTo) {
		// transforms value of both parameters to upper case (if DS100 code is entered
		// e.g. in lower case)
		codeFrom = codeFrom.toUpperCase();
		codeTo = codeTo.toUpperCase();
		// both parameters are being forwarded to the parameterized constructor of Distance class
		return new Distance(codeFrom, codeTo);
	}
}
