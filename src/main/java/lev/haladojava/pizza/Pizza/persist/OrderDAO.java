package lev.haladojava.pizza.Pizza.persist;

import lev.haladojava.pizza.Pizza.model.Order;

import java.util.List;

public interface OrderDAO {
    Order getOrder(int id);

    List<Order> getAllOrder();

    void insertOrder(Order order);

    void updateOrder(Order order);

    void deleteOrder(Order order);

    boolean idUsed(int id);
}
