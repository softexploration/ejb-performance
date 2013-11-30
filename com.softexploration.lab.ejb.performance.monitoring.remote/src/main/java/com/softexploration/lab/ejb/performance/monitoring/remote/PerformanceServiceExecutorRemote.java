package com.softexploration.lab.ejb.performance.monitoring.remote;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.softexploration.lab.ejb.performance.monitoring.PerformanceServiceExecutor;
import com.softexploration.lab.ejb.performance.monitoring.impl.PerformanceServiceExecutorBean;

@Singleton
@Startup
@TransactionAttribute(TransactionAttributeType.NEVER)
public class PerformanceServiceExecutorRemote extends
		PerformanceServiceExecutorBean implements
		PerformanceServiceExecutorRemoteMXBean {

	@EJB(beanName = "SequentialPerformanceServiceExecutorRemoteBean")
	public void setPerformanceServiceExecutor(
			PerformanceServiceExecutor performanceServiceExecutor) {
		super.setPerformanceServiceExecutor(performanceServiceExecutor);
	}

}
