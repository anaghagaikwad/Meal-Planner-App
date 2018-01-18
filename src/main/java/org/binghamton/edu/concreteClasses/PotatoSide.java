package org.binghamton.edu.concreteClasses;

import org.binghamton.edu.util.Side;

public class PotatoSide extends Side {

	@Override
	public String itemName() {
		String name = "potato";
		return name;
	}

	@Override
	public void prepareSide() {
		System.out.println("Potato ordered");
		
	}

}
