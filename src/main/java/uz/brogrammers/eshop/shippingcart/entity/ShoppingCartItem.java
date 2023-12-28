package uz.brogrammers.eshop.shippingcart.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "shipping_cart_item")
@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
public class ShoppingCartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "product_id", nullable = false)
    private Integer productId;
}
