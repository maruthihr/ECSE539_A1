/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse.pds.model;
import java.util.*;
import java.io.Serializable;

// line 46 "../../../../../PDS.ump"
public class StandardPizza extends Pizza implements Serializable
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Map<String, StandardPizza> standardpizzasByName = new HashMap<String, StandardPizza>();

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StandardPizza Attributes
  private int calorieCount;
  private String name;

  //StandardPizza Associations
  private List<Topping> toppings;
  private PDS pDS;
  private Menu menu;
  private List<Customization> customizations;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StandardPizza(double aPrice, int aCalorieCount, String aName, PDS aPDS, Menu aMenu)
  {
    super(aPrice);
    // line 53 "../../../../../PDS.ump"
    if (aName == null || aName.length() == 0) {
    	  throw new RuntimeException("The name of a Pizza cannot be empty.");
    	}
    // END OF UMPLE BEFORE INJECTION
    // line 59 "../../../../../PDS.ump"
    if (aCalorieCount <= 0) {
    	  throw new RuntimeException("The calorieCount of a Pizza cannot be empty.");
    	}
    // END OF UMPLE BEFORE INJECTION
    calorieCount = aCalorieCount;
    if (!setName(aName))
    {
      throw new RuntimeException("Cannot create due to duplicate name");
    }
    toppings = new ArrayList<Topping>();
    boolean didAddPDS = setPDS(aPDS);
    if (!didAddPDS)
    {
      throw new RuntimeException("Unable to create standardPizza due to pDS");
    }
    boolean didAddMenu = setMenu(aMenu);
    if (!didAddMenu)
    {
      throw new RuntimeException("Unable to create standardPizza due to menu");
    }
    customizations = new ArrayList<Customization>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCalorieCount(int aCalorieCount)
  {
    boolean wasSet = false;
    // line 59 "../../../../../PDS.ump"
    if (aCalorieCount <= 0) {
    	  throw new RuntimeException("The calorieCount of a Pizza cannot be empty.");
    	}
    // END OF UMPLE BEFORE INJECTION
    calorieCount = aCalorieCount;
    wasSet = true;
    return wasSet;
  }

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    // line 53 "../../../../../PDS.ump"
    if (aName == null || aName.length() == 0) {
    	  throw new RuntimeException("The name of a Pizza cannot be empty.");
    	}
    // END OF UMPLE BEFORE INJECTION
    String anOldName = getName();
    if (hasWithName(aName)) {
      return wasSet;
    }
    name = aName;
    wasSet = true;
    if (anOldName != null) {
      standardpizzasByName.remove(anOldName);
    }
    standardpizzasByName.put(aName, this);
    return wasSet;
  }

  public int getCalorieCount()
  {
    return calorieCount;
  }

  public String getName()
  {
    return name;
  }
  /* Code from template attribute_GetUnique */
  public static StandardPizza getWithName(String aName)
  {
    return standardpizzasByName.get(aName);
  }
  /* Code from template attribute_HasUnique */
  public static boolean hasWithName(String aName)
  {
    return getWithName(aName) != null;
  }
  /* Code from template association_GetMany */
  public Topping getTopping(int index)
  {
    Topping aTopping = toppings.get(index);
    return aTopping;
  }

  public List<Topping> getToppings()
  {
    List<Topping> newToppings = Collections.unmodifiableList(toppings);
    return newToppings;
  }

  public int numberOfToppings()
  {
    int number = toppings.size();
    return number;
  }

  public boolean hasToppings()
  {
    boolean has = toppings.size() > 0;
    return has;
  }

  public int indexOfTopping(Topping aTopping)
  {
    int index = toppings.indexOf(aTopping);
    return index;
  }
  /* Code from template association_GetOne */
  public PDS getPDS()
  {
    return pDS;
  }
  /* Code from template association_GetOne */
  public Menu getMenu()
  {
    return menu;
  }
  /* Code from template association_GetMany */
  public Customization getCustomization(int index)
  {
    Customization aCustomization = customizations.get(index);
    return aCustomization;
  }

  public List<Customization> getCustomizations()
  {
    List<Customization> newCustomizations = Collections.unmodifiableList(customizations);
    return newCustomizations;
  }

  public int numberOfCustomizations()
  {
    int number = customizations.size();
    return number;
  }

  public boolean hasCustomizations()
  {
    boolean has = customizations.size() > 0;
    return has;
  }

  public int indexOfCustomization(Customization aCustomization)
  {
    int index = customizations.indexOf(aCustomization);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfToppings()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addTopping(Topping aTopping)
  {
    boolean wasAdded = false;
    if (toppings.contains(aTopping)) { return false; }
    toppings.add(aTopping);
    if (aTopping.indexOfStandardPizza(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aTopping.addStandardPizza(this);
      if (!wasAdded)
      {
        toppings.remove(aTopping);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeTopping(Topping aTopping)
  {
    boolean wasRemoved = false;
    if (!toppings.contains(aTopping))
    {
      return wasRemoved;
    }

    int oldIndex = toppings.indexOf(aTopping);
    toppings.remove(oldIndex);
    if (aTopping.indexOfStandardPizza(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aTopping.removeStandardPizza(this);
      if (!wasRemoved)
      {
        toppings.add(oldIndex,aTopping);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addToppingAt(Topping aTopping, int index)
  {  
    boolean wasAdded = false;
    if(addTopping(aTopping))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfToppings()) { index = numberOfToppings() - 1; }
      toppings.remove(aTopping);
      toppings.add(index, aTopping);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveToppingAt(Topping aTopping, int index)
  {
    boolean wasAdded = false;
    if(toppings.contains(aTopping))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfToppings()) { index = numberOfToppings() - 1; }
      toppings.remove(aTopping);
      toppings.add(index, aTopping);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addToppingAt(aTopping, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOneToMany */
  public boolean setPDS(PDS aPDS)
  {
    boolean wasSet = false;
    if (aPDS == null)
    {
      return wasSet;
    }

    PDS existingPDS = pDS;
    pDS = aPDS;
    if (existingPDS != null && !existingPDS.equals(aPDS))
    {
      existingPDS.removeStandardPizza(this);
    }
    pDS.addStandardPizza(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMandatoryMany */
  public boolean setMenu(Menu aMenu)
  {
    boolean wasSet = false;
    //Must provide menu to standardPizza
    if (aMenu == null)
    {
      return wasSet;
    }

    if (menu != null && menu.numberOfStandardPizzas() <= Menu.minimumNumberOfStandardPizzas())
    {
      return wasSet;
    }

    Menu existingMenu = menu;
    menu = aMenu;
    if (existingMenu != null && !existingMenu.equals(aMenu))
    {
      boolean didRemove = existingMenu.removeStandardPizza(this);
      if (!didRemove)
      {
        menu = existingMenu;
        return wasSet;
      }
    }
    menu.addStandardPizza(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCustomizations()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addCustomization(Customization aCustomization)
  {
    boolean wasAdded = false;
    if (customizations.contains(aCustomization)) { return false; }
    customizations.add(aCustomization);
    if (aCustomization.indexOfStandardPizza(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aCustomization.addStandardPizza(this);
      if (!wasAdded)
      {
        customizations.remove(aCustomization);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeCustomization(Customization aCustomization)
  {
    boolean wasRemoved = false;
    if (!customizations.contains(aCustomization))
    {
      return wasRemoved;
    }

    int oldIndex = customizations.indexOf(aCustomization);
    customizations.remove(oldIndex);
    if (aCustomization.indexOfStandardPizza(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aCustomization.removeStandardPizza(this);
      if (!wasRemoved)
      {
        customizations.add(oldIndex,aCustomization);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addCustomizationAt(Customization aCustomization, int index)
  {  
    boolean wasAdded = false;
    if(addCustomization(aCustomization))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCustomizations()) { index = numberOfCustomizations() - 1; }
      customizations.remove(aCustomization);
      customizations.add(index, aCustomization);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCustomizationAt(Customization aCustomization, int index)
  {
    boolean wasAdded = false;
    if(customizations.contains(aCustomization))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCustomizations()) { index = numberOfCustomizations() - 1; }
      customizations.remove(aCustomization);
      customizations.add(index, aCustomization);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCustomizationAt(aCustomization, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    standardpizzasByName.remove(getName());
    ArrayList<Topping> copyOfToppings = new ArrayList<Topping>(toppings);
    toppings.clear();
    for(Topping aTopping : copyOfToppings)
    {
      aTopping.removeStandardPizza(this);
    }
    PDS placeholderPDS = pDS;
    this.pDS = null;
    if(placeholderPDS != null)
    {
      placeholderPDS.removeStandardPizza(this);
    }
    Menu placeholderMenu = menu;
    this.menu = null;
    if(placeholderMenu != null)
    {
      placeholderMenu.removeStandardPizza(this);
    }
    ArrayList<Customization> copyOfCustomizations = new ArrayList<Customization>(customizations);
    customizations.clear();
    for(Customization aCustomization : copyOfCustomizations)
    {
      aCustomization.removeStandardPizza(this);
    }
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "calorieCount" + ":" + getCalorieCount()+ "," +
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "pDS = "+(getPDS()!=null?Integer.toHexString(System.identityHashCode(getPDS())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "menu = "+(getMenu()!=null?Integer.toHexString(System.identityHashCode(getMenu())):"null");
  }
  
  public static void reinitializeUniquePizzaNames(List<StandardPizza> standardPizzas) {
	    standardpizzasByName = new HashMap<String, StandardPizza>();
	    for (StandardPizza standardPizza : standardPizzas) {
	      standardpizzasByName.put(standardPizza.getName(), standardPizza);
	  }
	}

private static final long serialVersionUID = 2045406856025012133L;
}