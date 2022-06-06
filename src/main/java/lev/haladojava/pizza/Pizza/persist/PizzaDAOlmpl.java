package lev.haladojava.pizza.Pizza.persist;

import lev.haladojava.pizza.Pizza.model.Pizza;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PizzaDAOlmpl implements PizzaDAO{

    private Map<Integer, Pizza> pizzaMap;

    public PizzaDAOlmpl(){
        pizzaMap = new HashMap<>();
        pizzaMap.put(1, new Pizza(1, "Bolognai", 1500, "healts"));
    }

    @Override
    public Pizza getPizza(int id) {
        return pizzaMap.get(id);
    }

    @Override
    public List<Pizza> getAllPizza() {
        return new ArrayList<Pizza>(pizzaMap.values());
    }

    @Override
    public void insertPizza(Pizza pizza) {
        pizzaMap.put(pizza.getId(), pizza);
    }

    @Override
    public void updatePizza(Pizza pizza) {
        pizzaMap.replace(pizza.getId(), pizza);
    }

    @SuppressWarnings("unlikely-arg-type")
	@Override
    public void deletePizza(Pizza pizza) {
        pizzaMap.remove(pizza);
    }

    @Override
    public boolean idUsed(int id) {
        return pizzaMap.containsKey(id);
    }
}
