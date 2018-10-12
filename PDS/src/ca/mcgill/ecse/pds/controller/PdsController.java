package ca.mcgill.ecse.pds.controller;


import java.util.List;

import ca.mcgill.ecse.pds.application.PdsApplication;
import ca.mcgill.ecse.pds.controller.InvalidInputException;
import ca.mcgill.ecse.pds.model.Menu;
import ca.mcgill.ecse.pds.model.PDS;
import ca.mcgill.ecse.pds.model.StandardPizza;

public class PdsController {

	public PdsController() {
	}
	

	
	public static StandardPizza createStandardPizza(String name, int price, int calorieCount) throws InvalidInputException {
		PDS pds = PdsApplication.getPds();
		Menu pdsMenu = PdsApplication.getPdsMenu();
		StandardPizza sp = null;
		try {
			// addStandardPizza(int aPrice, String aSize, int aQuantity, int aCalorieCount, String aName)
			// public StandardPizza addStandardPizza(double aPrice, int aCalorieCount, String aName, Menu aMenu)
			// addStandardPizza(double aPrice, int aCalorieCount, String aName, Menu aMenu)
			sp = pds.addStandardPizza(price, calorieCount, name, pdsMenu);
			PdsApplication.save();
			List<StandardPizza> pizzaList = pdsMenu.getStandardPizzas();
		    for (StandardPizza standardPizza : pizzaList) {
			      System.out.println(standardPizza.getName());
			
		}
		}
		catch (RuntimeException e) {
			throw new InvalidInputException(e.getMessage());
		}
		
		return sp;
	}
}

/*Controller: InvalidInputException
createStandardPizza() shall automatically update the menu
deleteStandardPizza()
updateStandardPizza()
getMenu()
getStandardPizzaPrice()
getStandardPizzaName()

Todo:
Size to be fixed in umple
Quantity to be deleted from pizza
price type to be changed to double

*/