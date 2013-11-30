package com.softexploration.lab.ejb.performance.client.local;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.softexploration.lab.ejb.performance.client.ClientPerformanceService;
import com.softexploration.lab.ejb.performance.client.impl.ClientPerformanceServiceBean;
import com.softexploration.lab.ejb.performance.service.BusinessPerformanceServiceLocal;

@Local(ClientPerformanceService.class)
@Stateless(name = "ClientPerformanceServiceLocalBean")
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class ClientPerformanceServiceLocalBean extends ClientPerformanceServiceBean {

	@EJB
	private BusinessPerformanceServiceLocal businessPerformanceService;

	@PostConstruct
	void init() {
		setBusinessPerformanceService(businessPerformanceService);
	}
}
