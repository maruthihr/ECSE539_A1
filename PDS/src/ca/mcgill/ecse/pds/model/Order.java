/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package ca.mcgill.ecse.pds.model;
import java.sql.Date;
import java.util.*;

// line 85 "../../../../../PDS.ump"
public class Order
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static int nextOrderNumber = 1;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Order Attributes
  private int numberOfItems;
  private double totalPrice;
  private Date date;

  //Autounique Attributes
  private int orderNumber;

  //Order Associations
  private PDS pDS;
  private Customer customer;
  private List<Customization> customizations;
  private List<OrderDetail> orderDetails;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Order(int aNumberOfItems, double aTotalPrice, Date aDate, PDS aPDS, Customer aCustomer)
  {
    numberOfItems = aNumberOfItems;
    totalPrice = aTotalPrice;
    date = aDate;
    orderNumber = nextOrderNumber++;
    boolean didAddPDS = setPDS(aPDS);
    if (!didAddPDS)
    {
      throw new RuntimeException("Unable to create order due to pDS");
    }
    boolean didAddCustomer = setCustomer(aCustomer);
    if (!didAddCustomer)
    {
      throw new RuntimeException("Unable to create order due to customer");
    }
    customizations = new ArrayList<Customization>();
    orderDetails = new ArrayList<OrderDetail>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNumberOfItems(int aNumberOfItems)
  {
    boolean wasSet = false;
    numberOfItems = aNumberOfItems;
    wasSet = true;
    return wasSet;
  }

  public boolean setTotalPrice(double aTotalPrice)
  {
    boolean wasSet = false;
    totalPrice = aTotalPrice;
    wasSet = true;
    return wasSet;
  }

  public boolean setDate(Date aDate)
  {
    boolean wasSet = false;
    date = aDate;
    wasSet = true;
    return wasSet;
  }

  public int getNumberOfItems()
  {
    return numberOfItems;
  }

  public double getTotalPrice()
  {
    return totalPrice;
  }

  public Date getDate()
  {
    return date;
  }

  public int getOrderNumber()
  {
    return orderNumber;
  }
  /* Code from template association_GetOne */
  public PDS getPDS()
  {
    return pDS;
  }
  /* Code from template association_GetOne */
  public Customer getCustomer()
  {
    return customer;
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
      existingPDS.removeOrder(this);
    }
    pDS.addOrder(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setCustomer(Customer aCustomer)
  {
    boolean wasSet = false;
    if (aCustomer == null)
    {
      return wasSet;
    }

    Customer existingCustomer = customer;
    customer = aCustomer;
    if (existingCustomer != null && !existingCustomer.equals(aCustomer))
    {
      existingCustomer.removeOrder(this);
    }
    customer.addOrder(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCustomizations()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Customization addCustomization()
  {
    return new Customization(this);
  }

  public boolean addCustomization(Customization aCustomization)
  {
    boolean wasAdded = false;
    if (customizations.contains(aCustomization)) { return false; }
    Order existingOrder = aCustomization.getOrder();
    boolean isNewOrder = existingOrder != null && !this.equals(existingOrder);
    if (isNewOrder)
    {
      aCustomization.setOrder(this);
    }
    else
    {
      customizations.add(aCustomization);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCustomization(Customization aCustomization)
  {
    boolean wasRemoved = false;
    //Unable to remove aCustomization, as it must always have a order
    if (!this.equals(aCustomization.getOrder()))
    {
      customizations.remove(aCustomization);
      wasRemoved = true;
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfOrderDetails()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public OrderDetail addOrderDetail(int aQuantity, Pizza aPizza)
  {
    return new OrderDetail(aQuantity, aPizza, this);
  }

  public boolean addOrderDetail(OrderDetail aOrderDetail)
  {
    boolean wasAdded = false;
    if (orderDetails.contains(aOrderDetail)) { return false; }
    Order existingOrder = aOrderDetail.getOrder();
    boolean isNewOrder = existingOrder != null && !this.equals(existingOrder);
    if (isNewOrder)
    {
      aOrderDetail.setOrder(this);
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
    //Unable to remove aOrderDetail, as it must always have a order
    if (!this.equals(aOrderDetail.getOrder()))
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
    PDS placeholderPDS = pDS;
    this.pDS = null;
    if(placeholderPDS != null)
    {
      placeholderPDS.removeOrder(this);
    }
    Customer placeholderCustomer = customer;
    this.customer = null;
    if(placeholderCustomer != null)
    {
      placeholderCustomer.removeOrder(this);
    }
    for(int i=customizations.size(); i > 0; i--)
    {
      Customization aCustomization = customizations.get(i - 1);
      aCustomization.delete();
    }
    for(int i=orderDetails.size(); i > 0; i--)
    {
      OrderDetail aOrderDetail = orderDetails.get(i - 1);
      aOrderDetail.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "orderNumber" + ":" + getOrderNumber()+ "," +
            "numberOfItems" + ":" + getNumberOfItems()+ "," +
            "totalPrice" + ":" + getTotalPrice()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "date" + "=" + (getDate() != null ? !getDate().equals(this)  ? getDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "pDS = "+(getPDS()!=null?Integer.toHexString(System.identityHashCode(getPDS())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "customer = "+(getCustomer()!=null?Integer.toHexString(System.identityHashCode(getCustomer())):"null");
  }
}