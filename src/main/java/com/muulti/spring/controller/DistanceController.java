package com.muulti.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.muulti.spring.service.Distance;

@RestController
public class DistanceController {

	@GetMapping(value = "api/v1/distance/{codeFrom}/{codeTo}")
	public Distance getDistance(@PathVariable String codeFrom, @PathVariable String codeTo) {
		// transform entered code to upper case (if DS100 code is entered  e.g. in lower case)
		codeFrom = codeFrom.toUpperCase();
		codeTo = codeTo.toUpperCase();
		return new Distance(codeFrom, codeTo);
	}
}
