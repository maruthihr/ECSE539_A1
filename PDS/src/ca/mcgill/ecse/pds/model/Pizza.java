/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse.pds.model;
import java.util.*;

// line 28 "../../../../../PDS.ump"
public class Pizza
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  public static final int Size = 12;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Pizza Attributes
  private double price;

  //Pizza Associations
  private List<OrderDetail> orderDetails;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Pizza(double aPrice)
  {
    // line 33 "../../../../../PDS.ump"
    if (aPrice <= 0) {
    	  throw new RuntimeException("The price of a Pizza cannot be empty.");
    	}
    // END OF UMPLE BEFORE INJECTION
    price = aPrice;
    orderDetails = new ArrayList<OrderDetail>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPrice(double aPrice)
  {
    boolean wasSet = false;
    // line 33 "../../../../../PDS.ump"
    if (aPrice <= 0) {
    	  throw new RuntimeException("The price of a Pizza cannot be empty.");
    	}
    // END OF UMPLE BEFORE INJECTION
    price = aPrice;
    wasSet = true;
    return wasSet;
  }

  public double getPrice()
  {
    return price;
  }
  /* Code from template association_GetMany */
  public OrderDetail getOrderDetail(int index)
  {
    OrderDetail aOrderDetail = orderDetails.get(index);
    return aOrderDetail;
  }

  public List<OrderDetail> getOrderDetails()
  {
    List<OrderDetail> newOrderDetails = Collections.unmodifiableList(orderDetails);
    return newOrderDetails;
  }

  public int numberOfOrderDetails()
  {
    int number = orderDetails.size();
    return number;
  }

  public boolean hasOrderDetails()
  {
    boolean has = orderDetails.size() > 0;
    return has;
  }

  public int indexOfOrderDetail(OrderDetail aOrderDetail)
  {
    int index = orderDetails.indexOf(aOrderDetail);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfOrderDetails()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public OrderDetail addOrderDetail(int aQuantity, Order aOrder)
  {
    return new OrderDetail(aQuantity, this, aOrder);
  }

  public boolean addOrderDetail(OrderDetail aOrderDetail)
  {
    boolean wasAdded = false;
    if (orderDetails.contains(aOrderDetail)) { return false; }
    Pizza existingPizza = aOrderDetail.getPizza();
    boolean isNewPizza = existingPizza != null && !this.equals(existingPizza);
    if (isNewPizza)
    {
      aOrderDetail.setPizza(this);
    }
    else
    {
      orderDetails.add(aOrderDetail);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeOrderDetail(OrderDetail aOrderDetail)
  {
    boolean wasRemoved = false;
    //Unable to remove aOrderDetail, as it must always have a pizza
    if (!this.equals(aOrderDetail.getPizza()))
    {
      orderDetails.remove(aOrderDetail);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addOrderDetailAt(OrderDetail aOrderDetail, int index)
  {  
    boolean wasAdded = false;
    if(addOrderDetail(aOrderDetail))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrderDetails()) { index = numberOfOrderDetails() - 1; }
      orderDetails.remove(aOrderDetail);
      orderDetails.add(index, aOrderDetail);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOrderDetailAt(OrderDetail aOrderDetail, int index)
  {
    boolean wasAdded = false;
    if(orderDetails.contains(aOrderDetail))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrderDetails()) { index = numberOfOrderDetails() - 1; }
      orderDetails.remove(aOrderDetail);
      orderDetails.add(index, aOrderDetail);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOrderDetailAt(aOrderDetail, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=orderDetails.size(); i > 0; i--)
    {
      OrderDetail aOrderDetail = orderDetails.get(i - 1);
      aOrderDetail.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "price" + ":" + getPrice()+ "]";
  }
}