package org.binghamton.edu.builder;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import org.binghamton.edu.util.Breakfast;
import org.binghamton.edu.util.Dinner;
import org.binghamton.edu.util.ItemInterface;
import org.binghamton.edu.util.Logger;

public class Meal {
	public Map<String,Integer> orderItemsMap = new LinkedHashMap<String,Integer>();
	public Map<ItemInterface,Integer> resultItemsMap = new LinkedHashMap<ItemInterface,Integer>(); 
	

	public void takeOrderItems(String inputString) {
		//System.out.println("In takeOrder");
		String[] itemString= inputString.trim().split(",");
		List<String> list = new ArrayList<String>();
		for(int i = 1;i<itemString.length;i++)
			list.add(itemString[i]);
			
		Collections.sort(list);
		
		String[] reorderItemString = new String[itemString.length]; 
		reorderItemString[0] = itemString[0];
		for(int j=1;j<=list.size();j++)
			reorderItemString[j] = list.get(j-1);
	
		initializeMap(reorderItemString);
		
	}


	private void initializeMap(String[] itemString) {
		orderItemsMap.put(itemString[0].toLowerCase(), 1);
		
		for(int i=1;i<itemString.length;i++)
		{
			if(!orderItemsMap.containsKey(itemString[i]))
				orderItemsMap.put(itemString[i], 1);
			else
				orderItemsMap.put(itemString[i], orderItemsMap.get(itemString[i])+1);
		}
		//System.out.println("Map : "+orderItemsMap.toString());
	}

	public void prepareMeal(String inputString){
		//System.out.println("In prepareMeal");
		if(inputString.contains("morning"))
		{
			Breakfast breakfastMenu = new Breakfast(orderItemsMap);
			resultItemsMap =  breakfastMenu.prepareBreakfast();
			//System.out.println("Map : "+resultItemsMap.toString());
		}
		else if(inputString.contains("night"))
		{
			Dinner dinnerMenu = new Dinner(orderItemsMap);
			resultItemsMap = dinnerMenu.prepareDinner();
		}
		
	}

	public void showOrderItems()
	{
		String result = null;
		for(ItemInterface m : resultItemsMap.keySet())
		{
			if(resultItemsMap.get(m)==-1)			//if key returns -1 its an error
			{
				if(result!=null)
					result = result + ", " + m.itemName();
				else
					result = m.itemName();
				break;
			}
			else if(resultItemsMap.get(m)>1)		//if key returns more than 1 multiple instances of item allowed
			{
				if(result!=null)
					result = result + ", " + m.itemName() + "(x"+resultItemsMap.get(m)+")";
				else
					result = m.itemName() + "(x"+resultItemsMap.get(m)+")";
				
			}
			else if(resultItemsMap.get(m)==0)		//if key returns 0 then print at least once
			{
				if(result!=null)
					result = result + m.itemName() + ", " +"error";
				else
					result = m.itemName() + ", " +"error";
				break;
			}
			else											//if key returns 1 only one item allowed
			{
				if(result!=null)
					result = result  + ", " + m.itemName();
				else
					result = m.itemName();
			}
		}
		
		Logger.writeOutput("Output: " + result,Logger.DebugLevel.INPUT_OUTPUT);
		Logger.writeOutput(" ",Logger.DebugLevel.INPUT_OUTPUT);
	}
}
