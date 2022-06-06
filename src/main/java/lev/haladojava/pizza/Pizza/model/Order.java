package lev.haladojava.pizza.Pizza.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Order {
    @NotNull
    private int id;
    @NotBlank
    private String customer;
    @NotNull
    private int hamburgerID;
    @NotNull
    private int hamburgerQuantity;
    @NotNull
    private int hotDogID;
    @NotNull
    private int hotDogQuantity;
    @NotNull
    private int pizzaID;
    @NotNull
    private int pizzaQuantity;
    @NotNull
    @Min(25)
    @Max(50)
    private int pizzaSize;
    @SuppressWarnings("unused")
	private String extraTopping;
    @NotBlank
    private String orderStatus;
    
    public Order(int ID, String Customer, int HamburgerID, int HamburgerQuantity,int HotDogID, int HotDogQuantity,int PizzaID, int PizzaQuantity, int PizzaSize, String ExtraTopping, String OrderStatus){
		this.id = ID;
		this.customer = Customer;
		this.hamburgerID = HamburgerID;
		this.hamburgerQuantity = HamburgerQuantity;
		this.hotDogID = HotDogID;
		this.hotDogQuantity = HotDogQuantity;
		this.pizzaID = PizzaID;
		this.pizzaQuantity = PizzaQuantity;
		this.pizzaSize = PizzaSize;
		this.extraTopping = ExtraTopping;
		this.orderStatus = OrderStatus;
	}
	
	 public int getId() {
	        return id;
	    }
	 
	 public void setOrderStatus(String status) {
	        this.orderStatus = status;
	    }

}
