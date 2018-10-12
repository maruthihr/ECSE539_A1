/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse.pds.model;
import java.util.*;

// line 72 "../../../../../PDS.ump"
public class Topping
{

  //------------------------
  // ENUMERATIONS
  //------------------------

  public enum ToppingName { Onion, Mushroom, Capsicum, GreenPepper, RedPepper }

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Topping Attributes
  private double toppingPrice;
  private ToppingName toppingName;

  //Topping Associations
  private PDS pDS;
  private List<CustomPizza> customPizzas;
  private List<StandardPizza> standardPizzas;
  private Customization customization;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Topping(double aToppingPrice, ToppingName aToppingName, PDS aPDS, Customization aCustomization)
  {
    toppingPrice = aToppingPrice;
    toppingName = aToppingName;
    boolean didAddPDS = setPDS(aPDS);
    if (!didAddPDS)
    {
      throw new RuntimeException("Unable to create topping due to pDS");
    }
    customPizzas = new ArrayList<CustomPizza>();
    standardPizzas = new ArrayList<StandardPizza>();
    boolean didAddCustomization = setCustomization(aCustomization);
    if (!didAddCustomization)
    {
      throw new RuntimeException("Unable to create topping due to customization");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setToppingPrice(double aToppingPrice)
  {
    boolean wasSet = false;
    toppingPrice = aToppingPrice;
    wasSet = true;
    return wasSet;
  }

  public boolean setToppingName(ToppingName aToppingName)
  {
    boolean wasSet = false;
    toppingName = aToppingName;
    wasSet = true;
    return wasSet;
  }

  public double getToppingPrice()
  {
    return toppingPrice;
  }

  public ToppingName getToppingName()
  {
    return toppingName;
  }
  /* Code from template association_GetOne */
  public PDS getPDS()
  {
    return pDS;
  }
  /* Code from template association_GetMany */
  public CustomPizza getCustomPizza(int index)
  {
    CustomPizza aCustomPizza = customPizzas.get(index);
    return aCustomPizza;
  }

  public List<CustomPizza> getCustomPizzas()
  {
    List<CustomPizza> newCustomPizzas = Collections.unmodifiableList(customPizzas);
    return newCustomPizzas;
  }

  public int numberOfCustomPizzas()
  {
    int number = customPizzas.size();
    return number;
  }

  public boolean hasCustomPizzas()
  {
    boolean has = customPizzas.size() > 0;
    return has;
  }

  public int indexOfCustomPizza(CustomPizza aCustomPizza)
  {
    int index = customPizzas.indexOf(aCustomPizza);
    return index;
  }
  /* Code from template association_GetMany */
  public StandardPizza getStandardPizza(int index)
  {
    StandardPizza aStandardPizza = standardPizzas.get(index);
    return aStandardPizza;
  }

  public List<StandardPizza> getStandardPizzas()
  {
    List<StandardPizza> newStandardPizzas = Collections.unmodifiableList(standardPizzas);
    return newStandardPizzas;
  }

  public int numberOfStandardPizzas()
  {
    int number = standardPizzas.size();
    return number;
  }

  public boolean hasStandardPizzas()
  {
    boolean has = standardPizzas.size() > 0;
    return has;
  }

  public int indexOfStandardPizza(StandardPizza aStandardPizza)
  {
    int index = standardPizzas.indexOf(aStandardPizza);
    return index;
  }
  /* Code from template association_GetOne */
  public Customization getCustomization()
  {
    return customization;
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
      existingPDS.removeTopping(this);
    }
    pDS.addTopping(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCustomPizzas()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addCustomPizza(CustomPizza aCustomPizza)
  {
    boolean wasAdded = false;
    if (customPizzas.contains(aCustomPizza)) { return false; }
    customPizzas.add(aCustomPizza);
    if (aCustomPizza.indexOfTopping(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aCustomPizza.addTopping(this);
      if (!wasAdded)
      {
        customPizzas.remove(aCustomPizza);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeCustomPizza(CustomPizza aCustomPizza)
  {
    boolean wasRemoved = false;
    if (!customPizzas.contains(aCustomPizza))
    {
      return wasRemoved;
    }

    int oldIndex = customPizzas.indexOf(aCustomPizza);
    customPizzas.remove(oldIndex);
    if (aCustomPizza.indexOfTopping(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aCustomPizza.removeTopping(this);
      if (!wasRemoved)
      {
        customPizzas.add(oldIndex,aCustomPizza);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addCustomPizzaAt(CustomPizza aCustomPizza, int index)
  {  
    boolean wasAdded = false;
    if(addCustomPizza(aCustomPizza))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCustomPizzas()) { index = numberOfCustomPizzas() - 1; }
      customPizzas.remove(aCustomPizza);
      customPizzas.add(index, aCustomPizza);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCustomPizzaAt(CustomPizza aCustomPizza, int index)
  {
    boolean wasAdded = false;
    if(customPizzas.contains(aCustomPizza))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCustomPizzas()) { index = numberOfCustomPizzas() - 1; }
      customPizzas.remove(aCustomPizza);
      customPizzas.add(index, aCustomPizza);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCustomPizzaAt(aCustomPizza, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfStandardPizzas()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addStandardPizza(StandardPizza aStandardPizza)
  {
    boolean wasAdded = false;
    if (standardPizzas.contains(aStandardPizza)) { return false; }
    standardPizzas.add(aStandardPizza);
    if (aStandardPizza.indexOfTopping(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aStandardPizza.addTopping(this);
      if (!wasAdded)
      {
        standardPizzas.remove(aStandardPizza);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeStandardPizza(StandardPizza aStandardPizza)
  {
    boolean wasRemoved = false;
    if (!standardPizzas.contains(aStandardPizza))
    {
      return wasRemoved;
    }

    int oldIndex = standardPizzas.indexOf(aStandardPizza);
    standardPizzas.remove(oldIndex);
    if (aStandardPizza.indexOfTopping(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aStandardPizza.removeTopping(this);
      if (!wasRemoved)
      {
        standardPizzas.add(oldIndex,aStandardPizza);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addStandardPizzaAt(StandardPizza aStandardPizza, int index)
  {  
    boolean wasAdded = false;
    if(addStandardPizza(aStandardPizza))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStandardPizzas()) { index = numberOfStandardPizzas() - 1; }
      standardPizzas.remove(aStandardPizza);
      standardPizzas.add(index, aStandardPizza);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveStandardPizzaAt(StandardPizza aStandardPizza, int index)
  {
    boolean wasAdded = false;
    if(standardPizzas.contains(aStandardPizza))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStandardPizzas()) { index = numberOfStandardPizzas() - 1; }
      standardPizzas.remove(aStandardPizza);
      standardPizzas.add(index, aStandardPizza);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addStandardPizzaAt(aStandardPizza, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOneToMany */
  public boolean setCustomization(Customization aCustomization)
  {
    boolean wasSet = false;
    if (aCustomization == null)
    {
      return wasSet;
    }

    Customization existingCustomization = customization;
    customization = aCustomization;
    if (existingCustomization != null && !existingCustomization.equals(aCustomization))
    {
      existingCustomization.removeTopping(this);
    }
    customization.addTopping(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    PDS placeholderPDS = pDS;
    this.pDS = null;
    if(placeholderPDS != null)
    {
      placeholderPDS.removeTopping(this);
    }
    ArrayList<CustomPizza> copyOfCustomPizzas = new ArrayList<CustomPizza>(customPizzas);
    customPizzas.clear();
    for(CustomPizza aCustomPizza : copyOfCustomPizzas)
    {
      aCustomPizza.removeTopping(this);
    }
    ArrayList<StandardPizza> copyOfStandardPizzas = new ArrayList<StandardPizza>(standardPizzas);
    standardPizzas.clear();
    for(StandardPizza aStandardPizza : copyOfStandardPizzas)
    {
      aStandardPizza.removeTopping(this);
    }
    Customization placeholderCustomization = customization;
    this.customization = null;
    if(placeholderCustomization != null)
    {
      placeholderCustomization.removeTopping(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "toppingPrice" + ":" + getToppingPrice()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "toppingName" + "=" + (getToppingName() != null ? !getToppingName().equals(this)  ? getToppingName().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "pDS = "+(getPDS()!=null?Integer.toHexString(System.identityHashCode(getPDS())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "customization = "+(getCustomization()!=null?Integer.toHexString(System.identityHashCode(getCustomization())):"null");
  }
}