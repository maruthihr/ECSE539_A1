/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse.pds.model;
import java.util.*;

// line 109 "../../../../../PDS.ump"
public class Customization
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Customization Associations
  private List<Topping> toppings;
  private List<StandardPizza> standardPizzas;
  private Order order;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Customization(Order aOrder)
  {
    toppings = new ArrayList<Topping>();
    standardPizzas = new ArrayList<StandardPizza>();
    boolean didAddOrder = setOrder(aOrder);
    if (!didAddOrder)
    {
      throw new RuntimeException("Unable to create customization due to order");
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
  public Order getOrder()
  {
    return order;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfToppings()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Topping addTopping(double aToppingPrice, Topping.ToppingName aToppingName, PDS aPDS)
  {
    return new Topping(aToppingPrice, aToppingName, aPDS, this);
  }

  public boolean addTopping(Topping aTopping)
  {
    boolean wasAdded = false;
    if (toppings.contains(aTopping)) { return false; }
    Customization existingCustomization = aTopping.getCustomization();
    boolean isNewCustomization = existingCustomization != null && !this.equals(existingCustomization);
    if (isNewCustomization)
    {
      aTopping.setCustomization(this);
    }
    else
    {
      toppings.add(aTopping);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTopping(Topping aTopping)
  {
    boolean wasRemoved = false;
    //Unable to remove aTopping, as it must always have a customization
    if (!this.equals(aTopping.getCustomization()))
    {
      toppings.remove(aTopping);
      wasRemoved = true;
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
    if (aStandardPizza.indexOfCustomization(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aStandardPizza.addCustomization(this);
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
    if (aStandardPizza.indexOfCustomization(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aStandardPizza.removeCustomization(this);
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
  public boolean setOrder(Order aOrder)
  {
    boolean wasSet = false;
    if (aOrder == null)
    {
      return wasSet;
    }

    Order existingOrder = order;
    order = aOrder;
    if (existingOrder != null && !existingOrder.equals(aOrder))
    {
      existingOrder.removeCustomization(this);
    }
    order.addCustomization(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=toppings.size(); i > 0; i--)
    {
      Topping aTopping = toppings.get(i - 1);
      aTopping.delete();
    }
    ArrayList<StandardPizza> copyOfStandardPizzas = new ArrayList<StandardPizza>(standardPizzas);
    standardPizzas.clear();
    for(StandardPizza aStandardPizza : copyOfStandardPizzas)
    {
      aStandardPizza.removeCustomization(this);
    }
    Order placeholderOrder = order;
    this.order = null;
    if(placeholderOrder != null)
    {
      placeholderOrder.removeCustomization(this);
    }
  }

}