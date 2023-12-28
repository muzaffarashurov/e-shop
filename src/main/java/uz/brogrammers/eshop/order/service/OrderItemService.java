package uz.brogrammers.eshop.order.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.brogrammers.eshop.order.entity.OrderItem;
import uz.brogrammers.eshop.order.repository.OrderItemRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemService {

    private final OrderItemRepo orderItemRepo;

    public List<OrderItem> getOrderItems() {
        return orderItemRepo.findAll();
    }

}
