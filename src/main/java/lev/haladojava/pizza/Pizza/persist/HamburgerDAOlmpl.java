package lev.haladojava.pizza.Pizza.persist;

import lev.haladojava.pizza.Pizza.model.Hamburger;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class HamburgerDAOlmpl implements HamburgerDAO{

    private Map<Integer, Hamburger> hamburgerMap;

    public HamburgerDAOlmpl(){
        hamburgerMap = new HashMap<>();
        hamburgerMap.put(1, new Hamburger(1, "Sert�s", 1500));
    }

    @Override
    public Hamburger getHamburger(int id) {
        return hamburgerMap.get(id);
    }

    @Override
    public List<Hamburger> getAllHamburger() {
        return new ArrayList<Hamburger>(hamburgerMap.values());
    }

    @Override
    public void insertHamburger(Hamburger hamburger) {
        hamburgerMap.put(hamburger.getId(), hamburger);
    }

    @Override
    public void updateHamburger(Hamburger hamburger) {
        hamburgerMap.replace(hamburger.getId(), hamburger);
    }

    @SuppressWarnings("unlikely-arg-type")
	@Override
    public void deleteHamburger(Hamburger hamburger) {
        hamburgerMap.remove(hamburger);
    }

    @Override
    public boolean idUsed(int id) {
        return hamburgerMap.containsKey(id);
    }
}
