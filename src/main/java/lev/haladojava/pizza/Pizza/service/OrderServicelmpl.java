package lev.haladojava.pizza.Pizza.service;

import lev.haladojava.pizza.Pizza.model.Order;
import lev.haladojava.pizza.Pizza.persist.OrderDAO;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;

@Service
public class OrderServicelmpl implements OrderService{

    private OrderDAO orderDAO;

    public OrderServicelmpl(OrderDAO orderDAO){
        this.orderDAO = orderDAO;
    }

    @Override
    public List<Order> listAllOrder() {
        return orderDAO.getAllOrder();
    }

    @Override
    public Order getOneOrder(int id) {
        return orderDAO.getOrder(id);
    }

    @Override
    public void modifyOrder(Order order) {
        orderDAO.updateOrder(order);
    }

    @Override
    public void createOrder(Order order) {
        if (order.getId() < 1) {
            throw new InvalidParameterException("id cannot be less than one");
        }
        if (orderDAO.idUsed(order.getId())) {
            throw new InvalidParameterException("id is in use");
        }
        orderDAO.insertOrder(order);
    }

    @Override
    public void changeOrderStatus(int id, String status) {
        Order order = orderDAO.getOrder(id);
        order.setOrderStatus(status);
        orderDAO.updateOrder(order);
    }
}
