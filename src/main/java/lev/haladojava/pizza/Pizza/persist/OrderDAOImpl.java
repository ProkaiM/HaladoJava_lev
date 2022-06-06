package lev.haladojava.pizza.Pizza.persist;

import lev.haladojava.pizza.Pizza.model.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class OrderDAOImpl implements OrderDAO{

    private Map<Integer, Order> orderMap;

    public OrderDAOImpl(){
        orderMap = new HashMap<>();
        orderMap.put(1, new Order(1,
                "Pista",
                1,
                1,
                1,
                2,
                1,
                3,
                32,
                "fetasajt a pizz�ra",
                "Feldolgozva"));
    }

    @Override
    public Order getOrder(int id) {
        return orderMap.get(id);
    }

    @Override
    public List<Order> getAllOrder() {
        return new ArrayList<Order>(orderMap.values());
    }

    @Override
    public void insertOrder(Order order) {
        orderMap.put(order.getId(), order);
    }

    @Override
    public void updateOrder(Order order) {
        orderMap.replace(order.getId(), order);
    }

    @SuppressWarnings("unlikely-arg-type")
	@Override
    public void deleteOrder(Order order) {
        orderMap.remove(order);
    }

    @Override
    public boolean idUsed(int id) {
        return orderMap.containsKey(id);
    }
}
