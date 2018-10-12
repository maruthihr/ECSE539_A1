/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse.pds.model;
import java.util.*;
import java.sql.Date;
import java.io.Serializable;

// line 7 "../../../../../PDS.ump"
public class PDS implements Serializable
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PDS Associations
  private List<Base> bases;
  private List<Topping> toppings;
  private List<Order> orders;
  private List<Customer> customers;
  private Menu menu;
  private List<StandardPizza> standardPizzas;
  private List<CustomPizza> customPizzas;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PDS()
  {
    bases = new ArrayList<Base>();
    toppings = new ArrayList<Topping>();
    orders = new ArrayList<Order>();
    customers = new ArrayList<Customer>();
    standardPizzas = new ArrayList<StandardPizza>();
    customPizzas = new ArrayList<CustomPizza>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public Base getBase(int index)
  {
    Base aBase = bases.get(index);
    return aBase;
  }

  public List<Base> getBases()
  {
    List<Base> newBases = Collections.unmodifiableList(bases);
    return newBases;
  }

  public int numberOfBases()
  {
    int number = bases.size();
    return number;
  }

  public boolean hasBases()
  {
    boolean has = bases.size() > 0;
    return has;
  }

  public int indexOfBase(Base aBase)
  {
    int index = bases.indexOf(aBase);
    return index;
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
  /* Code from template association_GetMany */
  public Order getOrder(int index)
  {
    Order aOrder = orders.get(index);
    return aOrder;
  }

  public List<Order> getOrders()
  {
    List<Order> newOrders = Collections.unmodifiableList(orders);
    return newOrders;
  }

  public int numberOfOrders()
  {
    int number = orders.size();
    return number;
  }

  public boolean hasOrders()
  {
    boolean has = orders.size() > 0;
    return has;
  }

  public int indexOfOrder(Order aOrder)
  {
    int index = orders.indexOf(aOrder);
    return index;
  }
  /* Code from template association_GetMany */
  public Customer getCustomer(int index)
  {
    Customer aCustomer = customers.get(index);
    return aCustomer;
  }

  public List<Customer> getCustomers()
  {
    List<Customer> newCustomers = Collections.unmodifiableList(customers);
    return newCustomers;
  }

  public int numberOfCustomers()
  {
    int number = customers.size();
    return number;
  }

  public boolean hasCustomers()
  {
    boolean has = customers.size() > 0;
    return has;
  }

  public int indexOfCustomer(Customer aCustomer)
  {
    int index = customers.indexOf(aCustomer);
    return index;
  }
  /* Code from template association_GetOne */
  public Menu getMenu()
  {
    return menu;
  }

  public boolean hasMenu()
  {
    boolean has = menu != null;
    return has;
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfBases()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Base addBase(String aName)
  {
    return new Base(aName, this);
  }

  public boolean addBase(Base aBase)
  {
    boolean wasAdded = false;
    if (bases.contains(aBase)) { return false; }
    PDS existingPDS = aBase.getPDS();
    boolean isNewPDS = existingPDS != null && !this.equals(existingPDS);
    if (isNewPDS)
    {
      aBase.setPDS(this);
    }
    else
    {
      bases.add(aBase);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeBase(Base aBase)
  {
    boolean wasRemoved = false;
    //Unable to remove aBase, as it must always have a pDS
    if (!this.equals(aBase.getPDS()))
    {
      bases.remove(aBase);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addBaseAt(Base aBase, int index)
  {  
    boolean wasAdded = false;
    if(addBase(aBase))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBases()) { index = numberOfBases() - 1; }
      bases.remove(aBase);
      bases.add(index, aBase);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveBaseAt(Base aBase, int index)
  {
    boolean wasAdded = false;
    if(bases.contains(aBase))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBases()) { index = numberOfBases() - 1; }
      bases.remove(aBase);
      bases.add(index, aBase);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addBaseAt(aBase, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfToppings()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Topping addTopping(double aToppingPrice, Topping.ToppingName aToppingName, Customization aCustomization)
  {
    return new Topping(aToppingPrice, aToppingName, this, aCustomization);
  }

  public boolean addTopping(Topping aTopping)
  {
    boolean wasAdded = false;
    if (toppings.contains(aTopping)) { return false; }
    PDS existingPDS = aTopping.getPDS();
    boolean isNewPDS = existingPDS != null && !this.equals(existingPDS);
    if (isNewPDS)
    {
      aTopping.setPDS(this);
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
    //Unable to remove aTopping, as it must always have a pDS
    if (!this.equals(aTopping.getPDS()))
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
  public static int minimumNumberOfOrders()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Order addOrder(int aNumberOfItems, double aTotalPrice, Date aDate, Customer aCustomer)
  {
    return new Order(aNumberOfItems, aTotalPrice, aDate, this, aCustomer);
  }

  public boolean addOrder(Order aOrder)
  {
    boolean wasAdded = false;
    if (orders.contains(aOrder)) { return false; }
    PDS existingPDS = aOrder.getPDS();
    boolean isNewPDS = existingPDS != null && !this.equals(existingPDS);
    if (isNewPDS)
    {
      aOrder.setPDS(this);
    }
    else
    {
      orders.add(aOrder);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeOrder(Order aOrder)
  {
    boolean wasRemoved = false;
    //Unable to remove aOrder, as it must always have a pDS
    if (!this.equals(aOrder.getPDS()))
    {
      orders.remove(aOrder);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addOrderAt(Order aOrder, int index)
  {  
    boolean wasAdded = false;
    if(addOrder(aOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrders()) { index = numberOfOrders() - 1; }
      orders.remove(aOrder);
      orders.add(index, aOrder);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOrderAt(Order aOrder, int index)
  {
    boolean wasAdded = false;
    if(orders.contains(aOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrders()) { index = numberOfOrders() - 1; }
      orders.remove(aOrder);
      orders.add(index, aOrder);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOrderAt(aOrder, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCustomers()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Customer addCustomer(String aName, String aEmailAddress, String aPhoneNumber, String aDeliveryAddress)
  {
    return new Customer(aName, aEmailAddress, aPhoneNumber, aDeliveryAddress, this);
  }

  public boolean addCustomer(Customer aCustomer)
  {
    boolean wasAdded = false;
    if (customers.contains(aCustomer)) { return false; }
    PDS existingPDS = aCustomer.getPDS();
    boolean isNewPDS = existingPDS != null && !this.equals(existingPDS);
    if (isNewPDS)
    {
      aCustomer.setPDS(this);
    }
    else
    {
      customers.add(aCustomer);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCustomer(Customer aCustomer)
  {
    boolean wasRemoved = false;
    //Unable to remove aCustomer, as it must always have a pDS
    if (!this.equals(aCustomer.getPDS()))
    {
      customers.remove(aCustomer);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addCustomerAt(Customer aCustomer, int index)
  {  
    boolean wasAdded = false;
    if(addCustomer(aCustomer))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCustomers()) { index = numberOfCustomers() - 1; }
      customers.remove(aCustomer);
      customers.add(index, aCustomer);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCustomerAt(Customer aCustomer, int index)
  {
    boolean wasAdded = false;
    if(customers.contains(aCustomer))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCustomers()) { index = numberOfCustomers() - 1; }
      customers.remove(aCustomer);
      customers.add(index, aCustomer);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCustomerAt(aCustomer, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOptionalOneToOne */
  public boolean setMenu(Menu aNewMenu)
  {
    boolean wasSet = false;
    if (menu != null && !menu.equals(aNewMenu) && equals(menu.getPDS()))
    {
      //Unable to setMenu, as existing menu would become an orphan
      return wasSet;
    }

    menu = aNewMenu;
    PDS anOldPDS = aNewMenu != null ? aNewMenu.getPDS() : null;

    if (!this.equals(anOldPDS))
    {
      if (anOldPDS != null)
      {
        anOldPDS.menu = null;
      }
      if (menu != null)
      {
        menu.setPDS(this);
      }
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfStandardPizzas()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public StandardPizza addStandardPizza(double aPrice, int aCalorieCount, String aName, Menu aMenu)
  {
    return new StandardPizza(aPrice, aCalorieCount, aName, this, aMenu);
  }

  public boolean addStandardPizza(StandardPizza aStandardPizza)
  {
    boolean wasAdded = false;
    if (standardPizzas.contains(aStandardPizza)) { return false; }
    PDS existingPDS = aStandardPizza.getPDS();
    boolean isNewPDS = existingPDS != null && !this.equals(existingPDS);
    if (isNewPDS)
    {
      aStandardPizza.setPDS(this);
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
    //Unable to remove aStandardPizza, as it must always have a pDS
    if (!this.equals(aStandardPizza.getPDS()))
    {
      standardPizzas.remove(aStandardPizza);
      wasRemoved = true;
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCustomPizzas()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public CustomPizza addCustomPizza(double aPrice)
  {
    return new CustomPizza(aPrice, this);
  }

  public boolean addCustomPizza(CustomPizza aCustomPizza)
  {
    boolean wasAdded = false;
    if (customPizzas.contains(aCustomPizza)) { return false; }
    PDS existingPDS = aCustomPizza.getPDS();
    boolean isNewPDS = existingPDS != null && !this.equals(existingPDS);
    if (isNewPDS)
    {
      aCustomPizza.setPDS(this);
    }
    else
    {
      customPizzas.add(aCustomPizza);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCustomPizza(CustomPizza aCustomPizza)
  {
    boolean wasRemoved = false;
    //Unable to remove aCustomPizza, as it must always have a pDS
    if (!this.equals(aCustomPizza.getPDS()))
    {
      customPizzas.remove(aCustomPizza);
      wasRemoved = true;
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

  public void delete()
  {
    while (bases.size() > 0)
    {
      Base aBase = bases.get(bases.size() - 1);
      aBase.delete();
      bases.remove(aBase);
    }
    
    while (toppings.size() > 0)
    {
      Topping aTopping = toppings.get(toppings.size() - 1);
      aTopping.delete();
      toppings.remove(aTopping);
    }
    
    while (orders.size() > 0)
    {
      Order aOrder = orders.get(orders.size() - 1);
      aOrder.delete();
      orders.remove(aOrder);
    }
    
    while (customers.size() > 0)
    {
      Customer aCustomer = customers.get(customers.size() - 1);
      aCustomer.delete();
      customers.remove(aCustomer);
    }
    
    Menu existingMenu = menu;
    menu = null;
    if (existingMenu != null)
    {
      existingMenu.delete();
      existingMenu.setPDS(null);
    }
    while (standardPizzas.size() > 0)
    {
      StandardPizza aStandardPizza = standardPizzas.get(standardPizzas.size() - 1);
      aStandardPizza.delete();
      standardPizzas.remove(aStandardPizza);
    }
    
    while (customPizzas.size() > 0)
    {
      CustomPizza aCustomPizza = customPizzas.get(customPizzas.size() - 1);
      aCustomPizza.delete();
      customPizzas.remove(aCustomPizza);
    }
    
  }
  
  public void reinitialize() {
	    StandardPizza.reinitializeAutouniqueID(this.getStandardPizzas());
	  }

  // line 18 "../../../../../PDS.ump"
   public java.util.Date getCurrentDate(){
    java.util.Calendar cal = java.util.Calendar.getInstance();
    cal.set(Calendar.HOUR_OF_DAY, 0);
    cal.set(Calendar.MINUTE, 0);
    cal.set(Calendar.SECOND, 0);
    cal.set(Calendar.MILLISECOND, 0);
    java.util.Date date = cal.getTime();
    return date;
  }
   
   private static final long serialVersionUID = -2683593616927798071L;

}