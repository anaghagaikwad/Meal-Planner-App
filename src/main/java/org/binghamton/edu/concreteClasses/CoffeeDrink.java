package org.binghamton.edu.concreteClasses;

import org.binghamton.edu.util.Drink;

public class CoffeeDrink extends Drink {

	@Override
	public String itemName() {
		String name = "coffee";
		return name;
	}

	@Override
	public void prepareDrink() {
		System.out.println("Coffee ordered");;
		
	}

}
