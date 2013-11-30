package com.softexploration.lab.ejb.performance.service.domain;

import java.io.Serializable;

/**
 * Request definition for ComplexService
 */
public interface ComplexRequest extends Serializable {

	byte[] getByteArray();
}
