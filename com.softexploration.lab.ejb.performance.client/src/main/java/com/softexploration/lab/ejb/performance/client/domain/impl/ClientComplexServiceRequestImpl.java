package com.softexploration.lab.ejb.performance.client.domain.impl;

import com.softexploration.lab.ejb.performance.client.domain.ClientComplexServiceRequest;

public class ClientComplexServiceRequestImpl implements
		ClientComplexServiceRequest {

	private byte[] byteArray;

	public byte[] getByteArray() {
		return byteArray;
	}

	public void setByteArray(byte[] byteArray) {
		this.byteArray = byteArray;
	}

}
