package org.binghamton.edu.util;

public class Logger {
	
		public static enum DebugLevel { NO_OUTPUT,CONTENTS_OF_DATASTRUCTURE,ONLY_OUTPUT,INPUT_OUTPUT};

		private static DebugLevel debugLevel;


		public static void setDebugValue (int levelIn) 
		{
			switch (levelIn) 
			{
			case 0:
				debugLevel = DebugLevel.NO_OUTPUT;
				break;
			case 1:
				debugLevel = DebugLevel.INPUT_OUTPUT;
				break;
			case 2: 
				debugLevel = DebugLevel.ONLY_OUTPUT; 
				break;
			case 3:
				debugLevel = DebugLevel.CONTENTS_OF_DATASTRUCTURE; 
				break;
			
			}
		}

		public static void setDebugValue (DebugLevel levelIn) 
		{
			debugLevel = levelIn;
		}


		public static void writeOutput (String output, DebugLevel levelIn )
		{
			if (levelIn == debugLevel)
				System.out.println(output);
		}
		

		public String toString()
		{
			return "Debug Level is : " + debugLevel;
		}
}
