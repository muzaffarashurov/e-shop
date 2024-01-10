package uz.brogrammers.eshop.order.rest.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.brogrammers.eshop.order.entity.OrderItem;

import java.time.ZonedDateTime;
import java.util.Set;

@Getter
@Setter
@Builder
public class OrderResponse {
    private Integer id;
    private ZonedDateTime created;
    private Integer userId;
    private Set<OrderItem> items;
    private Integer shippingId;
}
