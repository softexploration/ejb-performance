package com.softexploration.lab.ejb.performance.service.domain.impl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.log4j.Logger;

import com.softexploration.lab.ejb.performance.service.domain.SimpleRequest;

public class SimpleRequestImpl implements SimpleRequest {

	private static final Logger LOG = Logger.getLogger(SimpleRequestImpl.class);
	private static final long serialVersionUID = 7479548272256284291L;

	private void writeObject(ObjectOutputStream out) {
		try {
			Thread.sleep(Long.valueOf(System.getProperty("sleepTime", "250")));
			out.defaultWriteObject();
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
	}

	private void readObject(ObjectInputStream in) {
		try {
			Thread.sleep(Long.valueOf(System.getProperty("sleepTime", "250")));
			in.defaultReadObject();
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
	}

}
