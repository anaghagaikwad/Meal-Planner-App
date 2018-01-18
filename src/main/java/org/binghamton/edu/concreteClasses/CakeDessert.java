package org.binghamton.edu.concreteClasses;

import org.binghamton.edu.util.Dessert;

public class CakeDessert extends Dessert {

	@Override
	public String itemName() {
		String name = "cake";
		return name;
	}

	@Override
	public void prepareDessert() {
		System.out.println("Cake ordered");
		
	}

}
