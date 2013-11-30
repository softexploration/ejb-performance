package com.softexploration.lab.ejb.performance.client.domain.impl;

import com.softexploration.lab.ejb.performance.client.domain.ClientSimpleServiceResponse;

public class ClientSimpleServiceResponseImpl extends ClientResponseImpl implements ClientSimpleServiceResponse{

	public ClientSimpleServiceResponseImpl(long executionTime) {
		super(executionTime);
	}
}
