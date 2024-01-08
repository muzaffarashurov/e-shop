package uz.brogrammers.eshop.shoppingcart.model;

import lombok.Builder;
import lombok.Data;
import uz.brogrammers.eshop.shoppingcart.entity.CartItem;

import java.time.ZonedDateTime;
import java.util.Set;

@Data
@Builder
public class CartModel {

    private Integer id;
    private ZonedDateTime created;
    private Set<CartItem> items;

}