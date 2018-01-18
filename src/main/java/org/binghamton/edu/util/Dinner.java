package org.binghamton.edu.util;

import java.util.Map;

import org.binghamton.edu.builder.Meal;
import org.binghamton.edu.constants.NightMenu;
import org.binghamton.edu.concreteClasses.SteakEntree;
import org.binghamton.edu.concreteClasses.PotatoSide;
import org.binghamton.edu.concreteClasses.WineDrink;
import org.binghamton.edu.concreteClasses.CakeDessert;
import org.binghamton.edu.concreteClasses.DummyErrorObjectClass;

public class Dinner {

	Meal dinnerMeal = new Meal();

	public Dinner(Map<String, Integer> orderItemsMapIn) {
		dinnerMeal.orderItemsMap = orderItemsMapIn;
	}

	public Map<ItemInterface,Integer> prepareDinner() {
		//System.out.println("In prepareDinner");
		
		for(String s: dinnerMeal.orderItemsMap.keySet())
		{
			if(s.contains(String.valueOf(NightMenu.steak.ordinal()+1)))
			{
				if(dinnerMeal.orderItemsMap.get(s)==1)
					dinnerMeal.resultItemsMap.put(new SteakEntree(), 1);
				else 
					dinnerMeal.resultItemsMap.put(new SteakEntree(), 0); 
			}
			else if(s.contains(String.valueOf(NightMenu.potato.ordinal()+1)))
			{
				dinnerMeal.resultItemsMap.put(new PotatoSide(), dinnerMeal.orderItemsMap.get(s));
			}
			else if(s.contains(String.valueOf(NightMenu.wine.ordinal()+1)))
			{
				if(dinnerMeal.orderItemsMap.get(s)==1)
					dinnerMeal.resultItemsMap.put(new WineDrink(), 1); 
				else
					dinnerMeal.resultItemsMap.put(new WineDrink(), 0);
			}
			else if(s.contains(String.valueOf(NightMenu.cake.ordinal()+1)))
			{
				if(dinnerMeal.orderItemsMap.get(s)==1)
					dinnerMeal.resultItemsMap.put(new CakeDessert(), 1); 
				else
					dinnerMeal.resultItemsMap.put(new CakeDessert(), 0);
			}
			else if(!s.contains("night"))
			{
				dinnerMeal.resultItemsMap.put(new DummyErrorObjectClass(), -1); 
			}
		}
		
		return dinnerMeal.resultItemsMap;
	}

}
