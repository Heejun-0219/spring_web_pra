package hello.itemservice.domain.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository // @Component 포함
public class ItemRepository {

    private static final Map<Long, Item> store = new HashMap<>(); // static
    // 동시에 접근하는 로직의 경우 해쉬맵을 사용하면 안된다. 대신 ConcurrentHashMap를 사용하자
    private static long sequence = 0L; // static
    // 이 또한 AtomicLong를 사용하자

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findByAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item updateParam) {
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore() {
        store.clear();
    }
}
