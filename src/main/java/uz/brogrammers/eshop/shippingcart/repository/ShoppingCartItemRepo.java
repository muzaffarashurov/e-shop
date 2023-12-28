package uz.brogrammers.eshop.shippingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.brogrammers.eshop.shippingcart.entity.ShoppingCartItem;


@Repository
public interface ShoppingCartItemRepo extends JpaRepository<ShoppingCartItem, Integer> {

}
