package com.softexploration.lab.ejb.performance.monitoring.remote;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.apache.log4j.Logger;

import com.softexploration.lab.ejb.performance.client.ClientPerformanceService;
import com.softexploration.lab.ejb.performance.monitoring.PerformanceServiceExecutor;
import com.softexploration.lab.ejb.performance.monitoring.impl.sequential.SequentialPerformanceServiceExecutor;

@Stateless(name = "SequentialPerformanceServiceExecutorRemoteBean")
@Local(PerformanceServiceExecutor.class)
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class SequentialPerformanceServiceExecutorRemoteBean extends
		SequentialPerformanceServiceExecutor {

	private final Logger logger = Logger
			.getLogger(SequentialPerformanceServiceExecutorRemoteBean.class);

	@Override
	public Logger getLogger() {
		return logger;
	}

	@EJB(beanName = "ClientPerformanceServiceRemoteBean")
	public void setClientPerformanceService(
			ClientPerformanceService clientPerformanceService) {
		super.setClientPerformanceService(clientPerformanceService);
	}
}
