package org.binghamton.edu.builder;

public class MealBuilder implements MealBuilderInterface{
	
	
	@Override
	public Meal constructMeal(String inputString) {
		//System.out.println("In mealbuilder");
		Meal meal = new Meal();
		meal.takeOrderItems(inputString);
		meal.prepareMeal(inputString);
		
		return meal;
	}

}
