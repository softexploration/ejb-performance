package com.softexploration.lab.ejb.performance.monitoring;

/**
 * Monitoring load-test end-user interface definition to execute performance
 * services
 */
public interface PerformanceServiceExecutor {

	/**
	 * execute NopService LoadTest
	 * 
	 * @param requestCount
	 *            - number of business service executions
	 */
	void executeNopServiceLoadTest(long requestCount);

	/**
	 * execute SimpleService LoadTest
	 * 
	 * @param requestCount
	 *            - number of business service executions
	 */
	void executeSimpleServiceLoadTest(long requestCount);

	/**
	 * execute ComplexService LoadTest
	 * 
	 * @param requestCount
	 *            - number of business service executions
	 */
	void executeComplexServiceLoadTest(long requestCount);
}
