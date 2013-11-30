package com.softexploration.lab.ejb.performance.client.domain.impl;

import com.softexploration.lab.ejb.performance.client.domain.ClientComplexServiceResponse;

public class ClientComplexServiceResponseImpl extends ClientResponseImpl
		implements ClientComplexServiceResponse {

	public ClientComplexServiceResponseImpl(long executionTime) {
		super(executionTime);
	}

	private byte[] byteArray;

	public byte[] getByteArray() {
		return byteArray;
	}

	public void setByteArray(byte[] byteArray) {
		this.byteArray = byteArray;
	}
}
