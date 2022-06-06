package lev.haladojava.pizza.Pizza.controller;

import lev.haladojava.pizza.Pizza.model.Order;
import lev.haladojava.pizza.Pizza.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;
import java.util.List;

@Controller
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @RequestMapping("allOrder")
    @ResponseBody
    public List<Order> allOrder(){
        return orderService.listAllOrder();
    }

    @RequestMapping("getOneOrder")
    @ResponseBody
    public Order getOneOrder(@RequestParam("id") int id){
        return orderService.getOneOrder(id);
    }

    @RequestMapping("modifyOrderStatus")
    @ResponseBody
    public String modifyOrderStatus(@RequestParam("id") int id,
                                   @RequestParam("status") String status){
        orderService.changeOrderStatus(id, status);
        return "OK";
    }

    @RequestMapping("createOrderAll")
    @ResponseBody
    public String createOrderAll(@RequestParam("id") int id,
                              @RequestParam("customer") String customer,
                              @RequestParam("hamburgerID") int hamburgerID,
                              @RequestParam("hamburgerQuantity") int hamburgerQuantity,
                              @RequestParam("hotDogID") int hotDogID,
                              @RequestParam("hotDogQuantity") int hotDogQuantity,
                              @RequestParam("pizzaID") int pizzaID,
                              @RequestParam("pizzaQuantity") int pizzaQuantity,
                              @RequestParam("pizzaSize") int pizzaSize,
                              @RequestParam("extraTopping") String extraTopping ){
        orderService.createOrder(new Order(id,
                customer,
                hamburgerID,
                hamburgerQuantity,
                hotDogID,
                hotDogQuantity,
                pizzaID,
                pizzaQuantity,
                pizzaSize,
                extraTopping,
                "Feldolgoz�s alatt."));
        return "OK";
    }

    @RequestMapping("createOrderHamburger")
    @ResponseBody
    public String createOrderHamburger(@RequestParam("id") int id,
                                 @RequestParam("customer") String customer,
                                 @RequestParam("hamburgerID") int hamburgerID,
                                 @RequestParam("hamburgerQuantity") int hamburgerQuantity,
                                 @RequestParam("extraTopping") String extraTopping ){
        orderService.createOrder(new Order(id,
                customer,
                hamburgerID,
                hamburgerQuantity,
                0,
                0,
                0,
                0,
                0,
                extraTopping,
                "Feldolgoz�s alatt."));
        return "OK";
    }

    @RequestMapping("createOrderHotDog")
    @ResponseBody
    public String createOrderHotDog(@RequestParam("id") int id,
                                 @RequestParam("customer") String customer,
                                 @RequestParam("hotDogID") int hotDogID,
                                 @RequestParam("hotDogQuantity") int hotDogQuantity,
                                 @RequestParam("extraTopping") String extraTopping ){
        orderService.createOrder(new Order(id,
                customer,
                0,
                0,
                hotDogID,
                hotDogQuantity,
                0,
                0,
                0,
                extraTopping,
                "Feldolgoz�s alatt."));
        return "OK";
    }

    @RequestMapping("createOrderPizza")
    @ResponseBody
    public String createOrderPizza(@RequestParam("id") int id,
                                 @RequestParam("customer") String customer,
                                 @RequestParam("pizzaID") int pizzaID,
                                 @RequestParam("pizzaQuantity") int pizzaQuantity,
                                 @RequestParam("pizzaSize") int pizzaSize,
                                 @RequestParam("extraTopping") String extraTopping ){
        orderService.createOrder(new Order(id,
                customer,
                0,
                0,
                0,
                0,
                pizzaID,
                pizzaQuantity,
                pizzaSize,
                extraTopping,
                "Feldolgoz�s alatt."));
        return "OK";
    }

    @ExceptionHandler(InvalidParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void invalidParameterExceptionHandler() {  }
}
