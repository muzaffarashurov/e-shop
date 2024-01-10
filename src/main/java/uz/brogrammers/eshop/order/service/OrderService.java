package uz.brogrammers.eshop.order.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.brogrammers.eshop.order.entity.Order;
import uz.brogrammers.eshop.order.mapper.OrderMapper;
import uz.brogrammers.eshop.order.model.OrderModel;
import uz.brogrammers.eshop.order.repository.OrderRepository;
import uz.brogrammers.eshop.order.rest.dto.OrderResponse;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;


    public List<OrderModel> getAllByUserId(Integer userId) {
        return orderRepository.findAllByUserId(userId).stream()
                .map(OrderMapper::mapToModel)
                .toList();
    }

    public Optional<OrderModel> getOrderById(Integer id) {
        return orderRepository.findById(id).map(OrderMapper::mapToModel);
    }

    public List<OrderModel> getAll() {
        return orderRepository.findAll().stream()
                .map(OrderMapper::mapToModel).toList();
    }

    public OrderResponse save(OrderModel order) {
        var entity=OrderMapper.mapToEntity(order);
        var saved= orderRepository.save(entity);
        return OrderMapper.mapToDto(saved);
    }
}
