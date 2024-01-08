package uz.brogrammers.eshop.shoppingcart.rest.dto;

import lombok.Builder;
import lombok.Getter;
import uz.brogrammers.eshop.shoppingcart.entity.CartItem;

import java.time.ZonedDateTime;
import java.util.Set;

@Getter
@Builder
public class CartResponse {

    private Integer id;
    private ZonedDateTime created;
    private Set<CartItem> items;

    public void removeitems() {
        this.items.clear();
    }
}
