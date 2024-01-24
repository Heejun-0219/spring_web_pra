package hello.itemservice.domain.item;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }

    @Test
    void save() {
        // given
        Item item = new Item("itemA", 10000, 10);

        // when
        Item savedItem = itemRepository.save(item);

        // then
        Item byId = itemRepository.findById(item.getId());
        assertThat(byId).isEqualTo(savedItem);
    }

    @Test
    void findAll() {
        // given
        Item itemA = new Item("itemA", 10000, 10);
        Item itemB = new Item("itemB", 10000, 10);

        itemRepository.save(itemA);
        itemRepository.save(itemB);
        // when
        List<Item> result = itemRepository.findByAll();

        // then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(itemB, itemA);

    }

    @Test
    void update() {
        // given
        Item itemA = new Item("itemA", 10000, 10);

        Item save = itemRepository.save(itemA);
        Long itemId = save.getId();
        // when
        Item itemB = new Item("itemB", 20000, 20);
        itemRepository.update(itemId, itemB);

        // then
        Item byId = itemRepository.findById(itemId);
        assertThat(byId.getItemName()).isEqualTo(itemB.getItemName());
        assertThat(byId.getPrice()).isEqualTo(itemB.getPrice());

    }

}