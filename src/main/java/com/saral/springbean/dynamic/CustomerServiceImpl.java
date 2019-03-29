package com.saral.springbean.dynamic;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl {

	private Customer dynamicCustomerWithAspect;

	
	// This comes from the property file as a key for the Map
	@Value("${dynamic.object.name}")
	private String object;

	@InjectDynamicObject
	public Customer getDynamicCustomerWithAspect() {
		return this.dynamicCustomerWithAspect;
	}

	@Override
	public String toString() {
		return "CustomerServiceImpl [dynamicCustomerWithAspect=" + dynamicCustomerWithAspect + ", object=" + object
				+ "]";
	}

	

}
