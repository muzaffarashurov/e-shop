package uz.brogrammers.eshop.order.mapper;

import uz.brogrammers.eshop.order.entity.Order;
import uz.brogrammers.eshop.order.model.OrderModel;
import uz.brogrammers.eshop.order.rest.dto.OrderResponse;

public class OrderMapper {

    public static OrderModel mapToModel(OrderResponse response) {
        return OrderModel.builder()
                .id(response.getId())
                .created(response.getCreated())
                .userId(response.getUserId())
                .items(response.getItems())
                .shippingId(response.getShippingId())
                .build();
    }
    public static OrderModel mapToModel(Order order) {
        return OrderModel.builder()
                .id(order.getId())
                .created(order.getCreated())
                .userId(order.getUserId())
                .items(order.getItems())
                .shippingId(order.getShippingId())
                .build();
    }

    public static Order mapToEntity(OrderModel model) {
        return Order.builder()
                .id(model.getId())
                .created(model.getCreated())
                .userId(model.getUserId())
                .items(model.getItems())
                .shippingId(model.getShippingId())
                .build();
    }

    public static OrderResponse mapToDto(OrderModel model) {
        return OrderResponse.builder()
                .id(model.getId())
                .created(model.getCreated())
                .userId(model.getUserId())
                .items(model.getItems())
                .shippingId(model.getShippingId())
                .build();
    }
    public static OrderResponse mapToDto(Order order) {
        return OrderResponse.builder()
                .id(order.getId())
                .created(order.getCreated())
                .userId(order.getUserId())
                .items(order.getItems())
                .shippingId(order.getShippingId())
                .build();
    }

}
