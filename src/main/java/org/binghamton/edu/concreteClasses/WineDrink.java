package org.binghamton.edu.concreteClasses;

import org.binghamton.edu.util.Drink;

public class WineDrink extends Drink {

	@Override
	public String itemName() {
		String name = "wine";
		return name;
	}

	@Override
	public void prepareDrink() {
		// TODO Auto-generated method stub
		System.out.println("Wine ordered");
	}

}
