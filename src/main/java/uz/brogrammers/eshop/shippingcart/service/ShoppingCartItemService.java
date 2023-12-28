package uz.brogrammers.eshop.shippingcart.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.brogrammers.eshop.shippingcart.entity.ShoppingCartItem;
import uz.brogrammers.eshop.shippingcart.repository.ShoppingCartItemRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShoppingCartItemService {

    private final ShoppingCartItemRepo shoppingCartItemRepos;

    public List<ShoppingCartItem> findAll() {
        return shoppingCartItemRepos.findAll();
    }
}
