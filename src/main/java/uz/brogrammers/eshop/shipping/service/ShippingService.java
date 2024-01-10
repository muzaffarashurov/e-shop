package uz.brogrammers.eshop.shipping.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.brogrammers.eshop.shipping.entity.Shipping;
import uz.brogrammers.eshop.shipping.repository.ShippingRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShippingService {

    private final ShippingRepository shippingRepository;

    public List<Shipping> getAll() {
        return shippingRepository.findAll();
    }

    public Shipping save(Shipping shipping) {
       return shippingRepository.save(shipping);
    }
}
