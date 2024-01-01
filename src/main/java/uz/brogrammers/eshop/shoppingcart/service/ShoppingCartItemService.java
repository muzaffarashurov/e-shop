package uz.brogrammers.eshop.shoppingcart.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.brogrammers.eshop.shoppingcart.entity.ShoppingCartItem;
import uz.brogrammers.eshop.shoppingcart.repository.ShoppingCartItemRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShoppingCartItemService {

    private final ShoppingCartItemRepo shoppingCartItemRepos;

    public List<ShoppingCartItem> findAll() {
        return shoppingCartItemRepos.findAll();
    }
}
