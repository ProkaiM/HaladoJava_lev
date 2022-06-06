package lev.haladojava.pizza.Pizza.service;

import lev.haladojava.pizza.Pizza.model.HotDog;

import java.util.List;

public interface HotDogService {
	List<HotDog> listAllHotDog();
    void modifyHotDog(HotDog hotDog);
    void modifyHotDogPrice(int id, int price);
    void createHotDog(HotDog hotDog);
}
