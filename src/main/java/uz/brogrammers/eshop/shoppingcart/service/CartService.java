package uz.brogrammers.eshop.shoppingcart.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.brogrammers.eshop.shoppingcart.entity.Cart;
import uz.brogrammers.eshop.shoppingcart.mapper.CartMapper;
import uz.brogrammers.eshop.shoppingcart.model.CartModel;
import uz.brogrammers.eshop.shoppingcart.repository.CartRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;

    public List<CartModel> findAll() {
        return cartRepository.findAll().stream()
                .map(CartMapper::mapToModel)
                .toList();
    }

    public Optional<CartModel> findById(Integer id) {
        return cartRepository.findById(id)
                .map(CartMapper::mapToModel);
    }

    public CartModel create(CartModel request) {
        var entity =CartMapper.mapToEntity(request);
       var saved = cartRepository.save(entity);
       return CartMapper.mapToModel(saved);
    }

    public CartModel save(CartModel cart) {
        var entity = CartMapper.mapToEntity(cart);
        var saved = cartRepository.save(entity);
        return CartMapper.mapToModel(saved);
    }

    public void deleteById(Integer id) {
        cartRepository.deleteById(id);
    }

}
