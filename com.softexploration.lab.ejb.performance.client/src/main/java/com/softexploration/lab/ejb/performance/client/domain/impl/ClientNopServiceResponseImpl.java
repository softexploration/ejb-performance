package com.softexploration.lab.ejb.performance.client.domain.impl;

import com.softexploration.lab.ejb.performance.client.domain.ClientNopServiceResponse;

public class ClientNopServiceResponseImpl extends ClientResponseImpl implements
		ClientNopServiceResponse {

	public ClientNopServiceResponseImpl(long executionTime) {
		super(executionTime);
	}
}
