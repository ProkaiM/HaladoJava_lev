package lev.haladojava.pizza.Pizza.persist;

import lev.haladojava.pizza.Pizza.model.Pizza;

import java.util.List;

public interface PizzaDAO {
    Pizza getPizza(int id);

    List<Pizza> getAllPizza();

    void insertPizza(Pizza pizza);

    void updatePizza(Pizza pizza);

    void deletePizza(Pizza pizza);

    boolean idUsed(int id);

}
