package com.softexploration.lab.ejb.performance.client.domain;

/**
 * Base response definition
 */
public interface ClientResponse {

	/**
	 * @return time (nano sec) taken to execute service method
	 */
	long getExecutionTime();
}
