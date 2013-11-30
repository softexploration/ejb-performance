package com.softexploration.lab.ejb.performance.client;

import com.softexploration.lab.ejb.performance.client.domain.ClientComplexServiceRequest;
import com.softexploration.lab.ejb.performance.client.domain.ClientComplexServiceResponse;
import com.softexploration.lab.ejb.performance.client.domain.ClientNopServiceRequest;
import com.softexploration.lab.ejb.performance.client.domain.ClientNopServiceResponse;
import com.softexploration.lab.ejb.performance.client.domain.ClientSimpleServiceRequest;
import com.softexploration.lab.ejb.performance.client.domain.ClientSimpleServiceResponse;

/**
 * Client's interface definition to execute performance services
 */
public interface ClientPerformanceService {

	/**
	 * Perform NopService
	 * 
	 * @param request
	 * @return ClientNopServiceResponse
	 */
	ClientNopServiceResponse performNopService(ClientNopServiceRequest request);

	/**
	 * Perform SimpleService
	 * 
	 * @param request
	 * @return ClientSimpleServiceRequest
	 */
	ClientSimpleServiceResponse performSimpleService(
			ClientSimpleServiceRequest request);

	/**
	 * Perform ComplexService
	 * 
	 * @param request
	 * @return ClientComplexServiceRequest
	 */
	ClientComplexServiceResponse performComplexService(
			ClientComplexServiceRequest request);
}
