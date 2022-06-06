package lev.haladojava.pizza.Pizza.persist;

import lev.haladojava.pizza.Pizza.model.HotDog;

import java.util.List;

public interface HotDogDAO {
    HotDog getHotDog(int id);

    List<HotDog> getAllHotDog();

    void insertHotDog(HotDog hotDog);

    void updateHotDog(HotDog hotDog);

    void deleteHotDog(HotDog hotDog);

    boolean idUsed(int id);
}
