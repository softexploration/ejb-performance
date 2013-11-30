package com.softexploration.lab.ejb.performance.monitoring.impl.sequential;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.apache.log4j.Logger;

import com.softexploration.lab.ejb.performance.client.ClientPerformanceService;
import com.softexploration.lab.ejb.performance.client.domain.ClientComplexServiceResponse;
import com.softexploration.lab.ejb.performance.client.domain.ClientNopServiceResponse;
import com.softexploration.lab.ejb.performance.client.domain.ClientSimpleServiceResponse;
import com.softexploration.lab.ejb.performance.client.domain.impl.ClientComplexServiceRequestImpl;
import com.softexploration.lab.ejb.performance.client.domain.impl.ClientNopServiceRequestImpl;
import com.softexploration.lab.ejb.performance.client.domain.impl.ClientSimpleServiceRequestImpl;
import com.softexploration.lab.ejb.performance.monitoring.PerformanceServiceExecutor;

/**
 * Default implementation of <code>PerformanceServiceExecutor</code>.<br/>
 * Methods results are handled by logger.
 */
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class SequentialPerformanceServiceExecutor implements
		PerformanceServiceExecutor {

	public static final int s5MB = 5242880;
	private final Logger logger = Logger
			.getLogger(SequentialPerformanceServiceExecutor.class);

	public Logger getLogger() {
		return logger;
	}

	public ClientPerformanceService getClientPerformanceService() {
		return clientPerformanceService;
	}

	private ClientPerformanceService clientPerformanceService;

	public void setClientPerformanceService(
			ClientPerformanceService clientPerformanceService) {
		this.clientPerformanceService = clientPerformanceService;
	}

	public void executeNopServiceLoadTest(long requestCount) {
		List<Long> res = new LinkedList<Long>();
		for (long i = 0; i < requestCount; ++i) {
			ClientNopServiceRequestImpl targetRequest = new ClientNopServiceRequestImpl();
			ClientNopServiceResponse targetResponse = clientPerformanceService
					.performNopService(targetRequest);
			res.add(Long.valueOf(targetResponse.getExecutionTime()));
		}
		if (getLogger().isInfoEnabled()) {
			getLogger().info(
					new StringBuilder().append("executeNopServiceLoadTest:")
							.append(res.toString()));
		}
	}

	public void executeSimpleServiceLoadTest(long requestCount) {
		List<Long> res = new LinkedList<Long>();
		for (long i = 0; i < requestCount; ++i) {
			ClientSimpleServiceRequestImpl targetRequest = new ClientSimpleServiceRequestImpl();
			ClientSimpleServiceResponse targetResponse = clientPerformanceService
					.performSimpleService(targetRequest);
			res.add(Long.valueOf(targetResponse.getExecutionTime()));
		}
		if (getLogger().isInfoEnabled()) {
			getLogger().info(
					new StringBuilder().append("executeSimpleServiceLoadTest:")
							.append(res.toString()));
		}
	}

	public void executeComplexServiceLoadTest(long requestCount) {
		List<Long> res = new LinkedList<Long>();
		for (long i = 0; i < requestCount; ++i) {
			ClientComplexServiceRequestImpl targetRequest = new ClientComplexServiceRequestImpl();
			targetRequest.setByteArray(new byte[s5MB]);
			ClientComplexServiceResponse targetResponse = clientPerformanceService
					.performComplexService(targetRequest);
			res.add(Long.valueOf(targetResponse.getExecutionTime()));
		}
		if (getLogger().isInfoEnabled()) {
			getLogger().info(
					new StringBuilder()
							.append("executeComplexServiceLoadTest:").append(
									res.toString()));
		}
	}
}
