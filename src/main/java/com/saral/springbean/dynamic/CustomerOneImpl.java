package com.saral.springbean.dynamic;

import org.springframework.stereotype.Component;

@Component("customerOne")
public class CustomerOneImpl implements Customer {

	@Override
	public String getName() {
		return "Customer One";
	}

	@Override
	public String toString() {
		return "CustomerOneImpl [getName()=" + getName() + "]";
	}
	
	

}
