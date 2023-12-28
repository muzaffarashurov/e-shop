package uz.brogrammers.eshop.shippingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.brogrammers.eshop.shippingcart.entity.ShippingCart;

@Repository
public interface ShippingCartRepo extends JpaRepository<ShippingCart, Integer> {

}
