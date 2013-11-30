package com.softexploration.lab.ejb.performance.client.domain.impl;

import com.softexploration.lab.ejb.performance.client.domain.ClientResponse;

public class ClientResponseImpl implements ClientResponse {

	private long executionTime;

	public ClientResponseImpl(long executionTime) {
		this.executionTime = executionTime;
	}

	public long getExecutionTime() {
		return executionTime;
	}
}
