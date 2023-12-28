package uz.brogrammers.eshop.shipping.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.brogrammers.eshop.shipping.entity.Shipping;
import uz.brogrammers.eshop.shipping.repository.ShippingRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShippingService {

    private final ShippingRepo shippingRepo;

    public List<Shipping> getAll() {
        return shippingRepo.findAll();
    }

}
