package org.binghamton.edu.concreteClasses;

import org.binghamton.edu.util.Entree;

public class SteakEntree extends Entree{

	@Override
	public String itemName() {
		String name = "steak";
		return name;
	}

	@Override
	public void prepareEntree() {
		System.out.println("Steak ordered");
		
	}

}
