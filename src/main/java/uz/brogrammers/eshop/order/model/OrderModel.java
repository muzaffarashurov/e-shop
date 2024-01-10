package uz.brogrammers.eshop.order.model;

import lombok.Builder;
import lombok.Getter;
import uz.brogrammers.eshop.order.entity.OrderItem;

import java.time.ZonedDateTime;
import java.util.Set;

@Getter
@Builder
public class OrderModel {
    private Integer id;
    private ZonedDateTime created;
    private Integer userId;
    private Set<OrderItem> items;
    private Integer shippingId;
}
