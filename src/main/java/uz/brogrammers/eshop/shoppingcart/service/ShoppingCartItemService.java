package uz.brogrammers.eshop.shoppingcart.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.brogrammers.eshop.shoppingcart.entity.ShoppingCartItem;
import uz.brogrammers.eshop.shoppingcart.repository.ShoppingCartItemRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShoppingCartItemService {

    private final ShoppingCartItemRepository shoppingCartItemRepository;

    public List<ShoppingCartItem> findAll() {
        return shoppingCartItemRepository.findAll();
    }
}
