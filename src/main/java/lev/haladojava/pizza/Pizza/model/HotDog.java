package lev.haladojava.pizza.Pizza.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class HotDog {
    @NotNull
    private int id;
    @NotBlank
    private String name;
    @NotNull
    @Min(1100)
    @Max(5500)
    private int price;
    
    public HotDog(int ID, String Name, int Price){
		this.id = ID;
		this.name = Name;
		this.price = Price;
	}
	
	 public int getId() {
	        return id;
	    }

	    public void setPrice(int price) {
	        this.price = price;
	    }
}