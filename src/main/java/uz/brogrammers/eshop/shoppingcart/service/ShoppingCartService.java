package uz.brogrammers.eshop.shoppingcart.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.brogrammers.eshop.shoppingcart.entity.ShoppingCart;
import uz.brogrammers.eshop.shoppingcart.repository.ShoppingCartRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShoppingCartService {

    private final ShoppingCartRepo shoppingCartRepo;

    public List<ShoppingCart> findAll() {
        return shoppingCartRepo.findAll();
    }

}
