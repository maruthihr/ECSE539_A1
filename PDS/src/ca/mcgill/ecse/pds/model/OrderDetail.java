/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse.pds.model;

// line 102 "../../../../../PDS.ump"
public class OrderDetail
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //OrderDetail Attributes
  private int quantity;

  //OrderDetail Associations
  private Pizza pizza;
  private Order order;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetPizza;
  private boolean canSetOrder;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public OrderDetail(int aQuantity, Pizza aPizza, Order aOrder)
  {
    cachedHashCode = -1;
    canSetPizza = true;
    canSetOrder = true;
    quantity = aQuantity;
    boolean didAddPizza = setPizza(aPizza);
    if (!didAddPizza)
    {
      throw new RuntimeException("Unable to create orderDetail due to pizza");
    }
    boolean didAddOrder = setOrder(aOrder);
    if (!didAddOrder)
    {
      throw new RuntimeException("Unable to create orderDetail due to order");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setQuantity(int aQuantity)
  {
    boolean wasSet = false;
    quantity = aQuantity;
    wasSet = true;
    return wasSet;
  }

  public int getQuantity()
  {
    return quantity;
  }
  /* Code from template association_GetOne */
  public Pizza getPizza()
  {
    return pizza;
  }
  /* Code from template association_GetOne */
  public Order getOrder()
  {
    return order;
  }
  /* Code from template association_SetOneToManyAssociationClass */
  public boolean setPizza(Pizza aPizza)
  {
    boolean wasSet = false;
    if (!canSetPizza) { return false; }
    if (aPizza == null)
    {
      return wasSet;
    }

    Pizza existingPizza = pizza;
    pizza = aPizza;
    if (existingPizza != null && !existingPizza.equals(aPizza))
    {
      existingPizza.removeOrderDetail(this);
    }
    if (!pizza.addOrderDetail(this))
    {
      pizza = existingPizza;
      wasSet = false;
    }
    else
    {
      wasSet = true;
    }
    return wasSet;
  }
  /* Code from template association_SetOneToManyAssociationClass */
  public boolean setOrder(Order aOrder)
  {
    boolean wasSet = false;
    if (!canSetOrder) { return false; }
    if (aOrder == null)
    {
      return wasSet;
    }

    Order existingOrder = order;
    order = aOrder;
    if (existingOrder != null && !existingOrder.equals(aOrder))
    {
      existingOrder.removeOrderDetail(this);
    }
    if (!order.addOrderDetail(this))
    {
      order = existingOrder;
      wasSet = false;
    }
    else
    {
      wasSet = true;
    }
    return wasSet;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    OrderDetail compareTo = (OrderDetail)obj;
  
    if (getPizza() == null && compareTo.getPizza() != null)
    {
      return false;
    }
    else if (getPizza() != null && !getPizza().equals(compareTo.getPizza()))
    {
      return false;
    }

    if (getOrder() == null && compareTo.getOrder() != null)
    {
      return false;
    }
    else if (getOrder() != null && !getOrder().equals(compareTo.getOrder()))
    {
      return false;
    }

    return true;
  }

  public int hashCode()
  {
    if (cachedHashCode != -1)
    {
      return cachedHashCode;
    }
    cachedHashCode = 17;
    if (getPizza() != null)
    {
      cachedHashCode = cachedHashCode * 23 + getPizza().hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }
    if (getOrder() != null)
    {
      cachedHashCode = cachedHashCode * 23 + getOrder().hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetPizza = false;
    canSetOrder = false;
    return cachedHashCode;
  }

  public void delete()
  {
    Pizza placeholderPizza = pizza;
    this.pizza = null;
    if(placeholderPizza != null)
    {
      placeholderPizza.removeOrderDetail(this);
    }
    Order placeholderOrder = order;
    this.order = null;
    if(placeholderOrder != null)
    {
      placeholderOrder.removeOrderDetail(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "quantity" + ":" + getQuantity()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "pizza = "+(getPizza()!=null?Integer.toHexString(System.identityHashCode(getPizza())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "order = "+(getOrder()!=null?Integer.toHexString(System.identityHashCode(getOrder())):"null");
  }
}