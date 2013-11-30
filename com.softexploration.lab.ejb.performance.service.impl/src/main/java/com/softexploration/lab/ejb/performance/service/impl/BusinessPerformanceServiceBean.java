package com.softexploration.lab.ejb.performance.service.impl;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.softexploration.lab.ejb.performance.service.BusinessPerformanceService;
import com.softexploration.lab.ejb.performance.service.BusinessPerformanceServiceLocal;
import com.softexploration.lab.ejb.performance.service.BusinessPerformanceServiceRemote;
import com.softexploration.lab.ejb.performance.service.domain.ComplexRequest;
import com.softexploration.lab.ejb.performance.service.domain.ComplexResponse;
import com.softexploration.lab.ejb.performance.service.domain.SimpleRequest;
import com.softexploration.lab.ejb.performance.service.domain.SimpleResponse;
import com.softexploration.lab.ejb.performance.service.domain.impl.ComplexResponseImpl;
import com.softexploration.lab.ejb.performance.service.domain.impl.SimpleResponseImpl;

/**
 * Default implementation of <code>BusinessPerformanceService</code>
 */
@Stateless
@Local(BusinessPerformanceServiceLocal.class)
@Remote(BusinessPerformanceServiceRemote.class)
@TransactionAttribute(TransactionAttributeType.NEVER)
public class BusinessPerformanceServiceBean implements
		BusinessPerformanceService {

	public void nopService() {
	}

	public SimpleResponse simpleService(SimpleRequest request) {
		return new SimpleResponseImpl();
	}

	public ComplexResponse complexService(ComplexRequest request) {
		ComplexResponseImpl response = new ComplexResponseImpl();
		byte[] byteArray = request.getByteArray();
		if (byteArray != null) {
			for (int i = 0; i < byteArray.length; ++i) {
				byteArray[i] += 1;
			}
		}
		response.setByteArray(byteArray);
		return response;
	}

}
