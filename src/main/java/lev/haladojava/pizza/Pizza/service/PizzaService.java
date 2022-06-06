package lev.haladojava.pizza.Pizza.service;

import lev.haladojava.pizza.Pizza.model.Pizza;

import java.util.List;

public interface PizzaService {

	List<Pizza> listAllPizza();
    void modifyPasta(int id, String pasta);
    void modifyPizza(Pizza pizza);
    void createPizza(Pizza pizza);

}
