package lev.haladojava.pizza.Pizza.service;

import lev.haladojava.pizza.Pizza.model.Hamburger;

import java.util.List;

public interface HamburgerService {
	List<Hamburger> listAllHamburger();
    void modifyHamburger(Hamburger hamburger);
    void modifyHamburgerPrice(int id, int price);
    void createHamburger(Hamburger hamburger);
}
