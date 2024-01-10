package uz.brogrammers.eshop.order.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class OrderItemModel {

    private Integer id;
    private Integer quantity;
    private BigDecimal price;
    private Integer productId;

}
