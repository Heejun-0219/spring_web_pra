package hello.itemservice.domain.item;

import lombok.Data;

//@Data -> 너무 다양한 기능을 지원하기 때문에 핵심 도메인에 쓰기에는 위험하다
// 간단하게 데이터를 운반하는 경우에만 사용하자
//@Getter
//@Setter
@Data
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() {

    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
