package com.softexploration.lab.ejb.performance.service.domain.impl;

import org.apache.log4j.Logger;

import com.softexploration.lab.ejb.performance.service.domain.ComplexRequest;

public class ComplexRequestImpl implements ComplexRequest {

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(ComplexRequestImpl.class);
	private static final long serialVersionUID = -8301270147355416330L;

	private byte[] byteArray;

	public byte[] getByteArray() {
		return byteArray;
	}

	public void setByteArray(byte[] byteArray) {
		this.byteArray = byteArray;
	}

}
