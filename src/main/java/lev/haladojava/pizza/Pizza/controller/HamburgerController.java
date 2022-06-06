package lev.haladojava.pizza.Pizza.controller;

import lev.haladojava.pizza.Pizza.model.Hamburger;
import lev.haladojava.pizza.Pizza.service.HamburgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;
import java.util.List;

@Controller
public class HamburgerController {

    private HamburgerService hamburgerService;

    @Autowired
    public HamburgerController(HamburgerService hamburgerService){
        this.hamburgerService = hamburgerService;
    }

    @RequestMapping("allHamburger")
    @ResponseBody
    public List<Hamburger> getHamburgerList(){
        return hamburgerService.listAllHamburger();
    }

    @RequestMapping("modifyHamburger")
    @ResponseBody
    public String modifyHamburger(@RequestParam("id") int id,
                                  @RequestParam("name") String name,
                                  @RequestParam("price") int price){
        hamburgerService.modifyHamburger(new Hamburger(id,name,price));
        return "OK";
    }

    @RequestMapping("modifyHamburgerPrice")
    @ResponseBody
    public String modifyHamburgerPrice(@RequestParam("id") int id,
                                  @RequestParam("price") int price){
        hamburgerService.modifyHamburgerPrice(id,price);
        return "OK";
    }

    @RequestMapping("createHamburger")
    @ResponseBody
    public String createHamburger(@RequestParam("id") int id,
                              @RequestParam("name") String name,
                              @RequestParam("price") int price){
        hamburgerService.createHamburger(new Hamburger(id,name,price));
        return "OK";
    }

    @ExceptionHandler(InvalidParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void invalidParameterExceptionHandler() {  }
}
