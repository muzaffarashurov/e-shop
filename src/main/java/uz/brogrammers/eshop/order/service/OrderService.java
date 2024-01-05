package uz.brogrammers.eshop.order.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.brogrammers.eshop.order.entity.Order;
import uz.brogrammers.eshop.order.repository.OrderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public List<Order> getOrder(){
        return orderRepository.findAll();
    }
}
