package com.softexploration.lab.ejb.performance.client.remote;

import java.util.Hashtable;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.softexploration.lab.ejb.performance.client.ClientPerformanceService;
import com.softexploration.lab.ejb.performance.client.impl.ClientPerformanceServiceBean;
import com.softexploration.lab.ejb.performance.service.BusinessPerformanceServiceRemote;

@Local(ClientPerformanceService.class)
@Stateless(name = "ClientPerformanceServiceRemoteBean")
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class ClientPerformanceServiceRemoteBean extends
		ClientPerformanceServiceBean {

	@PostConstruct
	void init() {
		try {

			/*
			 * obtain reference to remote implementation of
			 * BusinessPerformanceServiceRemote
			 */
			Hashtable<String, String> env = new Hashtable<String, String>();
			env.put(Context.INITIAL_CONTEXT_FACTORY,
					System.getProperty("contextFactory"));
			env.put(Context.PROVIDER_URL, System.getProperty("providerURL"));
			Context ctx = new InitialContext(env);
			BusinessPerformanceServiceRemote businessPerformanceService = (BusinessPerformanceServiceRemote) ctx
					.lookup(System.getProperty("serviceJNDIname"));

			setBusinessPerformanceService(businessPerformanceService);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}
