package com.softexploration.lab.ejb.performance.monitoring.impl;

import java.lang.management.ManagementFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.management.MBeanServer;
import javax.management.ObjectName;

import com.softexploration.lab.ejb.performance.monitoring.PerformanceServiceExecutor;

/**
 * Wrapper for <code>PerformanceServiceExecutor</code> implementation.<br/>
 * There are defined crucial life cycle methods implementing JMX beans
 * registration.
 */
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class PerformanceServiceExecutorBean implements
		PerformanceServiceExecutor {

	private PerformanceServiceExecutor performanceServiceExecutor;
	private MBeanServer platformMBeanServer;
	private ObjectName objectName;

	public void setPerformanceServiceExecutor(
			PerformanceServiceExecutor performanceServiceExecutor) {
		this.performanceServiceExecutor = performanceServiceExecutor;
	}

	@PostConstruct
	void registerJMX() {
		platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
		try {
			objectName = new ObjectName(
					"com.softexploration.lab.ejb.performance.monitoring:type="
							+ this.getClass().getSimpleName());
			platformMBeanServer.registerMBean(this, objectName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PreDestroy
	void unregisterJMX() {
		try {
			platformMBeanServer.unregisterMBean(objectName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void executeNopServiceLoadTest(long requestCount) {
		performanceServiceExecutor.executeNopServiceLoadTest(requestCount);
	}

	public void executeSimpleServiceLoadTest(long requestCount) {
		performanceServiceExecutor.executeSimpleServiceLoadTest(requestCount);
	}

	public void executeComplexServiceLoadTest(long requestCount) {
		performanceServiceExecutor.executeComplexServiceLoadTest(requestCount);
	}

}
