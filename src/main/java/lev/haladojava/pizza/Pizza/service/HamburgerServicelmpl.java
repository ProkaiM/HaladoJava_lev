package lev.haladojava.pizza.Pizza.service;

import lev.haladojava.pizza.Pizza.model.Hamburger;
import lev.haladojava.pizza.Pizza.persist.HamburgerDAO;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;

@Service
public class HamburgerServicelmpl implements HamburgerService{

    private HamburgerDAO hamburgerDAO;

    public HamburgerServicelmpl(HamburgerDAO hamburegerDAO){
        this.hamburgerDAO = hamburegerDAO;
    }

    @Override
    public List<Hamburger> listAllHamburger() {
        return hamburgerDAO.getAllHamburger();
    }

    @Override
    public void modifyHamburger(Hamburger hamburger) {
        hamburgerDAO.updateHamburger(hamburger);
    }

    @Override
    public void modifyHamburgerPrice(int id, int price) {
        Hamburger hamburger = hamburgerDAO.getHamburger(id);
        hamburger.setPrice(price);
        hamburgerDAO.updateHamburger(hamburger);
    }

    @Override
    public void createHamburger(Hamburger hamburger) {
        if (hamburger.getId() < 1) {
            throw new InvalidParameterException("id cannot be less than one");
        }
        if (hamburgerDAO.idUsed(hamburger.getId())) {
            throw new InvalidParameterException("id is in use");
        }
        hamburgerDAO.insertHamburger(hamburger);
    }
}
