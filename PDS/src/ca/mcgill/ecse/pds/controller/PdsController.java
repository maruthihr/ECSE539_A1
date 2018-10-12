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
		Menu menu = PdsApplication.getPdsMenu();
		StandardPizza sp = null;
		try {
			// addStandardPizza(int aPrice, String aSize, int aQuantity, int aCalorieCount, String aName)
			// public StandardPizza addStandardPizza(double aPrice, int aCalorieCount, String aName, Menu aMenu)
			// addStandardPizza(double aPrice, int aCalorieCount, String aName, Menu aMenu)
			sp = pds.addStandardPizza(price, calorieCount, name, menu);
			PdsApplication.save();
			List<StandardPizza> pizzaList = menu.getStandardPizzas();
		    for (StandardPizza standardPizza : pizzaList) {
			      System.out.println(standardPizza.getName());
			
		}
		}
		catch (RuntimeException e) {
			throw new InvalidInputException(e.getMessage());
		}
		
		return sp;
	}
	
	public static void deleteStandardPizza(StandardPizza standardPizza) throws InvalidInputException {
		standardPizza.delete();
		System.out.println("deleteStandardPizza: deleted");
		
		PDS pds = PdsApplication.getPds();
		Menu menu = PdsApplication.getPdsMenu();
		List<StandardPizza> pizzaList = menu.getStandardPizzas();
	    for (StandardPizza standardPizza1 : pizzaList) {
		      System.out.println(standardPizza1.getName());
	    }
		try {
			PdsApplication.save();
		}
		catch (RuntimeException e) {
			throw new InvalidInputException(e.getMessage());
		}
	}
	
	public static List<StandardPizza> getStandardPizzasOnMenu() {
		Menu menu = PdsApplication.getPdsMenu();
		List<StandardPizza> pizzaList = menu.getStandardPizzas();
		return pizzaList;
	}
	
	public static void updateStandardPizza(String name, int price, int calorieCount) throws InvalidInputException {
		String error = "";
		PDS pds = PdsApplication.getPds();
		StandardPizza foundStandardPizaa = null;
		for (StandardPizza standardPizza : pds.getStandardPizzas()) {
			if (standardPizza.getName().equals(name)) {
				foundStandardPizaa = standardPizza;
				break;
			}
		}
		if (foundStandardPizaa == null) {
			error = "A standard pizza with this name does not exist. ";
		}
		if (price <= 0) {
			error = error + "The pizza price must be greater than zero. ";
		}
		if (calorieCount <= 0) {
			error = error + "The calorie count must be greater than zero.";
		}
		if (error.length() > 0) {
			throw new InvalidInputException(error.trim());
		}
		foundStandardPizaa.setName(name);
		foundStandardPizaa.setPrice(price);
		foundStandardPizaa.setCalorieCount(calorieCount);

		try {
			PdsApplication.save();
		}
		catch (RuntimeException e) {
			throw new InvalidInputException(e.getMessage());
		}
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