package uz.brogrammers.eshop.shoppingcart.mapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import uz.brogrammers.eshop.shoppingcart.entity.Cart;
import uz.brogrammers.eshop.shoppingcart.model.CartModel;
import uz.brogrammers.eshop.shoppingcart.rest.dto.CartResponse;

@Slf4j
@Component
@RequiredArgsConstructor
public class CartMapper {

    public static CartResponse mapToDto(CartModel model){
        return CartResponse.builder()
                .id(model.getId())
                .created(model.getCreated())
                .items(model.getItems())
                .build();
    }

    public static CartModel mapToModel(Cart cart){
        return CartModel.builder()
                .id(cart.getId())
                .created(cart.getCreated())
                .items(cart.getItems())
                .build();
    }
    public static CartModel mapToModel(CartResponse cart){
        return CartModel.builder()
                .id(cart.getId())
                .created(cart.getCreated())
                .items(cart.getItems())
                .build();
    }

    public static Cart mapToEntity(CartModel model){
        return Cart.builder()
                .id(model.getId())
                .created(model.getCreated())
                .items(model.getItems())
                .build();
    }

}
