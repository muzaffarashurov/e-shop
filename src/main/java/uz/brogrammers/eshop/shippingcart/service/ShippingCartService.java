package uz.brogrammers.eshop.shippingcart.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.brogrammers.eshop.shippingcart.entity.ShippingCart;
import uz.brogrammers.eshop.shippingcart.repository.ShippingCartRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShippingCartService {

    private final ShippingCartRepo shippingCartRepo;

    public List<ShippingCart> findAll() {
        return shippingCartRepo.findAll();
    }

}
