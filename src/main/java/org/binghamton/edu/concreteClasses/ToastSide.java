package org.binghamton.edu.concreteClasses;

import org.binghamton.edu.util.Side;

public class ToastSide extends Side{

	@Override
	public String itemName() {
		String name = "toast";
		return name;
	}

	@Override
	public void prepareSide() {
		System.out.println("Toast ordered");
		
	}

}
