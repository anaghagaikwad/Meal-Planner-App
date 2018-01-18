package org.binghamton.edu.concreteClasses;

import org.binghamton.edu.util.Entree;

public class EggEntree extends Entree {

	@Override
	public String itemName() {
		String name = "eggs";
		return name;
	}

	@Override
	public void prepareEntree() {
		System.out.println("Eggs ordered");
		
	}

}
