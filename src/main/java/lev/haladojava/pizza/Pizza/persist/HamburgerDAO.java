package lev.haladojava.pizza.Pizza.persist;

import lev.haladojava.pizza.Pizza.model.Hamburger;

import java.util.List;

public interface HamburgerDAO {
    Hamburger getHamburger(int id);

    List<Hamburger> getAllHamburger();

    void insertHamburger(Hamburger hamburger);

    void updateHamburger(Hamburger hamburger);

    void deleteHamburger(Hamburger hamburger);

    boolean idUsed(int id);
}
