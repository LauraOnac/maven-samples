package repos;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Laura on 10/21/2017.
 */
public class ConcurrentHashMapBasedRepository<T> implements InMemoryRepository<T> {
    private Map<Integer,T> map;

    public ConcurrentHashMapBasedRepository() {
        this.map = new ConcurrentHashMap<>();
    }

    @Override
    public void add(T element) {
        map.put(element.hashCode(), element);
    }

    @Override
    public boolean contains(T element) {
        return map.containsValue(element);
    }

    @Override
    public void remove(T element) {
        map.values().remove(element);
    }
}
