package com.softexploration.lab.ejb.performance.service;

import com.softexploration.lab.ejb.performance.service.domain.ComplexRequest;
import com.softexploration.lab.ejb.performance.service.domain.ComplexResponse;
import com.softexploration.lab.ejb.performance.service.domain.SimpleRequest;
import com.softexploration.lab.ejb.performance.service.domain.SimpleResponse;

/**
 * Business performance-measurement service interface definition
 */
public interface BusinessPerformanceService {

	/**
	 * Provide nopService
	 */
	void nopService();

	/**
	 * Provide simpleService
	 * 
	 * @param request
	 * @return SimpleResponse
	 */
	SimpleResponse simpleService(SimpleRequest request);

	/**
	 * Provide complexService
	 * 
	 * @param request
	 * @return ComplexResponse
	 */
	ComplexResponse complexService(ComplexRequest request);
}
