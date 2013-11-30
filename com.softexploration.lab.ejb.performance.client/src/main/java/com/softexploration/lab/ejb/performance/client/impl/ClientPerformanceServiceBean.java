package com.softexploration.lab.ejb.performance.client.impl;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.softexploration.lab.ejb.performance.client.ClientPerformanceService;
import com.softexploration.lab.ejb.performance.client.domain.ClientComplexServiceRequest;
import com.softexploration.lab.ejb.performance.client.domain.ClientComplexServiceResponse;
import com.softexploration.lab.ejb.performance.client.domain.ClientNopServiceRequest;
import com.softexploration.lab.ejb.performance.client.domain.ClientNopServiceResponse;
import com.softexploration.lab.ejb.performance.client.domain.ClientSimpleServiceRequest;
import com.softexploration.lab.ejb.performance.client.domain.ClientSimpleServiceResponse;
import com.softexploration.lab.ejb.performance.client.domain.impl.ClientComplexServiceResponseImpl;
import com.softexploration.lab.ejb.performance.client.domain.impl.ClientNopServiceResponseImpl;
import com.softexploration.lab.ejb.performance.client.domain.impl.ClientSimpleServiceResponseImpl;
import com.softexploration.lab.ejb.performance.service.BusinessPerformanceService;
import com.softexploration.lab.ejb.performance.service.domain.ComplexResponse;
import com.softexploration.lab.ejb.performance.service.domain.SimpleResponse;
import com.softexploration.lab.ejb.performance.service.domain.impl.ComplexRequestImpl;
import com.softexploration.lab.ejb.performance.service.domain.impl.SimpleRequestImpl;

/**
 * Default implementation of <code>ClientPerformanceService</code>
 * 
 */
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class ClientPerformanceServiceBean implements ClientPerformanceService {

	private BusinessPerformanceService businessPerformanceService;

	public void setBusinessPerformanceService(
			BusinessPerformanceService businessPerformanceService) {
		this.businessPerformanceService = businessPerformanceService;
	}

	public BusinessPerformanceService getBusinessPerformanceService() {
		return businessPerformanceService;
	}

	public ClientNopServiceResponse performNopService(
			ClientNopServiceRequest request) {
		long startTime = System.nanoTime();
		getBusinessPerformanceService().nopService();
		long stopTime = System.nanoTime() - startTime;
		ClientNopServiceResponseImpl response = new ClientNopServiceResponseImpl(
				stopTime);
		return response;
	}

	public ClientSimpleServiceResponse performSimpleService(
			ClientSimpleServiceRequest request) {
		long startTime = System.nanoTime();
		SimpleRequestImpl targetRequest = new SimpleRequestImpl();
		@SuppressWarnings("unused")
		SimpleResponse targetResponse = getBusinessPerformanceService()
				.simpleService(targetRequest);
		long stopTime = System.nanoTime() - startTime;
		ClientSimpleServiceResponseImpl response = new ClientSimpleServiceResponseImpl(
				stopTime);
		return response;
	}

	public ClientComplexServiceResponse performComplexService(
			ClientComplexServiceRequest request) {
		long startTime = System.nanoTime();
		ComplexRequestImpl targetRequest = new ComplexRequestImpl();
		targetRequest.setByteArray(request.getByteArray());
		ComplexResponse targetResponse = getBusinessPerformanceService()
				.complexService(targetRequest);
		long stopTime = System.nanoTime() - startTime;
		ClientComplexServiceResponseImpl response = new ClientComplexServiceResponseImpl(
				stopTime);
		response.setByteArray(targetResponse.getByteArray());
		return response;
	}
}
