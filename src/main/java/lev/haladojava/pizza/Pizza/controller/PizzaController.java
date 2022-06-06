package lev.haladojava.pizza.Pizza.controller;

import lev.haladojava.pizza.Pizza.model.Pizza;
import lev.haladojava.pizza.Pizza.service.PizzaService;
import lev.haladojava.pizza.Pizza.service.PizzaServicelmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;
import java.util.List;

@Controller
public class PizzaController {

    private PizzaService pizzaService;

    @Autowired
    public PizzaController(PizzaServicelmpl pizzaService){
        this.pizzaService = pizzaService;
    }

    @RequestMapping("allPizza")
    @ResponseBody
    public List<Pizza> getPizzaList(){
        return pizzaService.listAllPizza();
    }

    @RequestMapping("modifyPasta")
    @ResponseBody
    public String modifyPasta(@RequestParam("id") int id,
                              @RequestParam("pasta") String pasta){
        pizzaService.modifyPasta(id, pasta);
        return "OK";
    }

    @RequestMapping("modifyPizza")
    @ResponseBody
    public String modifyPizza(@RequestParam("id") int id,
                              @RequestParam("name") String name,
                              @RequestParam("price") int price,
                              @RequestParam("pasta") String pasta){
        pizzaService.modifyPizza(new Pizza(id,name,price,pasta));
        return "OK";
    }

    @RequestMapping("createPizza")
    @ResponseBody
    public String createPizza(@RequestParam("id") int id,
                              @RequestParam("name") String name,
                              @RequestParam("price") int price,
                              @RequestParam("pasta") String pasta){
        pizzaService.createPizza(new Pizza(id,name,price,pasta));
        return "OK";
    }

    @ExceptionHandler(InvalidParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void invalidParameterExceptionHandler() {  }
}
