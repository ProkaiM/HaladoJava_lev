package lev.haladojava.pizza.Pizza.controller;

import lev.haladojava.pizza.Pizza.model.HotDog;
import lev.haladojava.pizza.Pizza.service.HotDogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;
import java.util.List;

@Controller
public class HotDogController {

    private HotDogService hotDogService;

    @Autowired
    public HotDogController(HotDogService hotDogService){
        this.hotDogService = hotDogService;
    }

    @RequestMapping("allHotDog")
    @ResponseBody
    public List<HotDog> getHotDogList(){
        return hotDogService.listAllHotDog();
    }

    @RequestMapping("modifyHotDog")
    @ResponseBody
    public String modifyHotDog(@RequestParam("id") int id,
                               @RequestParam("name") String name,
                               @RequestParam("price") int price){
        hotDogService.modifyHotDog(new HotDog(id,name,price));
        return "OK";
    }

    @RequestMapping("modifyHotDogPrice")
    @ResponseBody
    public String modifyHotDog(@RequestParam("id") int id,
                               @RequestParam("price") int price){
        hotDogService.modifyHotDogPrice(id, price);
        return "OK";
    }

    @RequestMapping("createHotDog")
    @ResponseBody
    public String createHotDog(@RequestParam("id") int id,
                                  @RequestParam("name") String name,
                                  @RequestParam("price") int price){
        hotDogService.createHotDog(new HotDog(id,name,price));
        return "OK";
    }

    @ExceptionHandler(InvalidParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void invalidParameterExceptionHandler() {  }
}
