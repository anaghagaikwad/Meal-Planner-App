package org.binghamton.edu.driver;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.binghamton.edu.builder.Meal;
import org.binghamton.edu.builder.MealBuilder;
import org.binghamton.edu.builder.MealBuilderInterface;
import org.binghamton.edu.util.Logger;


public class Driver {
	
	public static void main(String[] args) {
		String line = null;
		Meal myMeal = new Meal();
		MealBuilderInterface builder = new MealBuilder();
		Logger.setDebugValue(1);
		try{
			FileReader fileReader = new FileReader(System.getProperty("user.dir")+"/classes/Input.txt");
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	        while((line = bufferedReader.readLine()) != null) {	
	           Logger.writeOutput("\nInput: "+line, Logger.DebugLevel.INPUT_OUTPUT);
	        	myMeal = builder.constructMeal(line);
	        	myMeal.showOrderItems();
	        }
	        bufferedReader.close();
		}
        catch(FileNotFoundException ex){
        	System.err.println("File not Found");
        }
		catch(IOException ex){
			System.err.println("Error reading file");
		}
	}

	
}
