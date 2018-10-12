/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse.pds.model;
import java.util.*;

// line 40 "../../../../../PDS.ump"
public class CustomPizza extends Pizza
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CustomPizza Associations
  private List<Topping> toppings;
  private PDS pDS;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CustomPizza(double aPrice, PDS aPDS)
  {
    super(aPrice);
    toppings = new ArrayList<Topping>();
    boolean didAddPDS = setPDS(aPDS);
    if (!didAddPDS)
    {
      throw new RuntimeException("Unable to create customPizza due to pDS");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------
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
    if (aTopping.indexOfCustomPizza(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aTopping.addCustomPizza(this);
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
    if (aTopping.indexOfCustomPizza(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aTopping.removeCustomPizza(this);
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
      existingPDS.removeCustomPizza(this);
    }
    pDS.addCustomPizza(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<Topping> copyOfToppings = new ArrayList<Topping>(toppings);
    toppings.clear();
    for(Topping aTopping : copyOfToppings)
    {
      aTopping.removeCustomPizza(this);
    }
    PDS placeholderPDS = pDS;
    this.pDS = null;
    if(placeholderPDS != null)
    {
      placeholderPDS.removeCustomPizza(this);
    }
    super.delete();
  }

}