package com.softexploration.lab.ejb.performance.service.domain.impl;

import org.apache.log4j.Logger;

import com.softexploration.lab.ejb.performance.service.domain.ComplexResponse;

public class ComplexResponseImpl implements ComplexResponse {

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger
			.getLogger(ComplexResponseImpl.class);
	private static final long serialVersionUID = 6495081014798136640L;

	private byte[] byteArray;

	public byte[] getByteArray() {
		return byteArray;
	}

	public void setByteArray(byte[] byteArray) {
		this.byteArray = byteArray;
	}
}
