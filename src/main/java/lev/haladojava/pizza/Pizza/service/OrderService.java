package lev.haladojava.pizza.Pizza.service;

import lev.haladojava.pizza.Pizza.model.Order;

import java.util.List;

public interface OrderService {
	List<Order> listAllOrder();
    Order getOneOrder(int id);
    void modifyOrder(Order order);
    void createOrder(Order order);

    void changeOrderStatus(int id, String status);
}
