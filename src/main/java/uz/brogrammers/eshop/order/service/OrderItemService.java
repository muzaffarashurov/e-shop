package uz.brogrammers.eshop.order.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.brogrammers.eshop.order.repository.OrderRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemService {

    private final OrderRepo orderRepo;

    public List<String> getOrderItems() {
        return orderRepo.getOrderItems();
    }

}
