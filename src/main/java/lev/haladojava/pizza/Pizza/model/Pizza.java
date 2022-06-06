package lev.haladojava.pizza.Pizza.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Pizza {
    @NotNull
    private int id;
    @NotBlank
    private String name;
    @NotNull
    @Min(1100)
    @Max(5500)
    private int price;
    @NotBlank
    private String pasta;
    
    
    public Pizza(int ID, String Name, int Price, String Pasta){
		this.id = ID;
		this.name = Name;
		this.price = Price;
		this.pasta = Pasta;
	}
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setPasta(String pasta) {
        this.pasta = pasta;
    }
}
