/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse.pds.model;
import java.util.*;
import java.io.Serializable;

// line 80 "../../../../../PDS.ump"
public class Menu  implements Serializable
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Menu Associations
  private List<StandardPizza> standardPizzas;
  private PDS pDS;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Menu(PDS aPDS)
  {
    standardPizzas = new ArrayList<StandardPizza>();
    boolean didAddPDS = setPDS(aPDS);
    if (!didAddPDS)
    {
      throw new RuntimeException("Unable to create menu due to pDS");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------
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
  public PDS getPDS()
  {
    return pDS;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfStandardPizzasValid()
  {
    boolean isValid = numberOfStandardPizzas() >= minimumNumberOfStandardPizzas();
    return isValid;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfStandardPizzas()
  {
    return 1;
  }
  /* Code from template association_AddMandatoryManyToOne */
  public StandardPizza addStandardPizza(double aPrice, int aCalorieCount, String aName, PDS aPDS)
  {
    StandardPizza aNewStandardPizza = new StandardPizza(aPrice, aCalorieCount, aName, aPDS, this);
    return aNewStandardPizza;
  }

  public boolean addStandardPizza(StandardPizza aStandardPizza)
  {
    boolean wasAdded = false;
    if (standardPizzas.contains(aStandardPizza)) { return false; }
    Menu existingMenu = aStandardPizza.getMenu();
    boolean isNewMenu = existingMenu != null && !this.equals(existingMenu);

    if (isNewMenu && existingMenu.numberOfStandardPizzas() <= minimumNumberOfStandardPizzas())
    {
      return wasAdded;
    }
    if (isNewMenu)
    {
      aStandardPizza.setMenu(this);
    }
    else
    {
      standardPizzas.add(aStandardPizza);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStandardPizza(StandardPizza aStandardPizza)
  {
    boolean wasRemoved = false;
    //Unable to remove aStandardPizza, as it must always have a menu
    if (this.equals(aStandardPizza.getMenu()))
    {
      return wasRemoved;
    }

    //menu already at minimum (1)
    if (numberOfStandardPizzas() <= minimumNumberOfStandardPizzas())
    {
      return wasRemoved;
    }

    standardPizzas.remove(aStandardPizza);
    wasRemoved = true;
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
  /* Code from template association_SetOneToOptionalOne */
  public boolean setPDS(PDS aNewPDS)
  {
    boolean wasSet = false;
    if (aNewPDS == null)
    {
      //Unable to setPDS to null, as menu must always be associated to a pDS
      return wasSet;
    }
    
    Menu existingMenu = aNewPDS.getMenu();
    if (existingMenu != null && !equals(existingMenu))
    {
      //Unable to setPDS, the current pDS already has a menu, which would be orphaned if it were re-assigned
      return wasSet;
    }
    
    PDS anOldPDS = pDS;
    pDS = aNewPDS;
    pDS.setMenu(this);

    if (anOldPDS != null)
    {
      anOldPDS.setMenu(null);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=standardPizzas.size(); i > 0; i--)
    {
      StandardPizza aStandardPizza = standardPizzas.get(i - 1);
      aStandardPizza.delete();
    }
    PDS existingPDS = pDS;
    pDS = null;
    if (existingPDS != null)
    {
      existingPDS.setMenu(null);
    }
  }
  
  public void reinitialize() {
	    StandardPizza.reinitializeAutouniqueID(this.getStandardPizzas());
	  }
  
  private static final long serialVersionUID = -2315072607928790501L;

}