package lev.haladojava.pizza.Pizza.persist;

import lev.haladojava.pizza.Pizza.model.HotDog;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class HotDogDAOImpl implements HotDogDAO {

    private Map<Integer, HotDog> hotDogMap;

    public HotDogDAOImpl(){
        hotDogMap = new HashMap<>();
        hotDogMap.put(1, new HotDog(1, "Sajtos", 1200));
    }

    @Override
    public HotDog getHotDog(int id) {
        return hotDogMap.get(id);
    }

    @Override
    public List<HotDog> getAllHotDog() {
        return new ArrayList<HotDog>(hotDogMap.values());
    }

    @Override
    public void insertHotDog(HotDog hotDog) {
        hotDogMap.put(hotDog.getId(), hotDog);
    }

    @Override
    public void updateHotDog(HotDog hotDog) {
        hotDogMap.replace(hotDog.getId(), hotDog);
    }

    @SuppressWarnings("unlikely-arg-type")
	@Override
    public void deleteHotDog(HotDog hotDog) {
        hotDogMap.remove(hotDog);
    }

    @Override
    public boolean idUsed(int id) {
        return hotDogMap.containsKey(id);
    }
}
