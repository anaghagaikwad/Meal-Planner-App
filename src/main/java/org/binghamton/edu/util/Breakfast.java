package org.binghamton.edu.util;

import java.util.Map;

import org.binghamton.edu.builder.Meal;
import org.binghamton.edu.concreteClasses.CoffeeDrink;
import org.binghamton.edu.concreteClasses.EggEntree;
import org.binghamton.edu.concreteClasses.DummyErrorObjectClass;
import org.binghamton.edu.concreteClasses.ToastSide;
import org.binghamton.edu.constants.MorningMenu;

public class Breakfast {

	Meal breakfastMeal = new Meal();
	
	public Breakfast(Map<String, Integer> orderItemsMapIn) {
		breakfastMeal.orderItemsMap  = orderItemsMapIn;
	}

	public Map<ItemInterface,Integer>  prepareBreakfast() {
		//System.out.println("In prepareBreakfast");
		
		
		for(String s: breakfastMeal.orderItemsMap.keySet())
		{
			if(s.contains(String.valueOf(MorningMenu.eggs.ordinal()+1)))
			{
				
				if(breakfastMeal.orderItemsMap.get(s)==1)
					breakfastMeal.resultItemsMap.put(new EggEntree(), 1);
				else 
					breakfastMeal.resultItemsMap.put(new EggEntree(), 0); 
			}
			else if(s.contains(String.valueOf(MorningMenu.toast.ordinal()+1)))
			{
				if(breakfastMeal.orderItemsMap.get(s)==1)
					breakfastMeal.resultItemsMap.put(new ToastSide(), 1); 
				else
					breakfastMeal.resultItemsMap.put(new ToastSide(), 0);
			}
			else if(s.contains(String.valueOf(MorningMenu.coffee.ordinal()+1)))
			{
				breakfastMeal.resultItemsMap.put(new CoffeeDrink(), breakfastMeal.orderItemsMap.get(s)); 
			}
			else if(!s.contains("morning")) 
			{
				breakfastMeal.resultItemsMap.put(new DummyErrorObjectClass(), -1); 
			}
		}
		
		
		return breakfastMeal.resultItemsMap; 
	}


	
}
