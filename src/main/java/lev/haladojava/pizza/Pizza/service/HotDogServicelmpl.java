package lev.haladojava.pizza.Pizza.service;

import lev.haladojava.pizza.Pizza.model.HotDog;
import lev.haladojava.pizza.Pizza.persist.HotDogDAO;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;

@Service
public class HotDogServicelmpl implements HotDogService{

    private HotDogDAO hotDogDAO;

    public HotDogServicelmpl(HotDogDAO hotDogDAO){
        this.hotDogDAO = hotDogDAO;
    }

    @Override
    public List<HotDog> listAllHotDog() {
        return hotDogDAO.getAllHotDog();
    }

    @Override
    public void modifyHotDog(HotDog hotDog) {
        hotDogDAO.updateHotDog(hotDog);
    }

    @Override
    public void modifyHotDogPrice(int id, int price) {
        HotDog hotDog = hotDogDAO.getHotDog(id);
        hotDog.setPrice(price);
        hotDogDAO.updateHotDog(hotDog);
    }

    @Override
    public void createHotDog(HotDog hotDog) {
        if (hotDog.getId() < 1) {
            throw new InvalidParameterException("id cannot be less than one");
        }
        if (hotDogDAO.idUsed(hotDog.getId())) {
            throw new InvalidParameterException("id is in use");
        }
        hotDogDAO.insertHotDog(hotDog);
    }
}
