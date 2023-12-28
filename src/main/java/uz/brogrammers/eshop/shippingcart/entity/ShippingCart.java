package uz.brogrammers.eshop.shippingcart.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "shipping_cart")

public class ShippingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "cart_item", joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private Set<ShoppingCartItem> items = new HashSet<>();
}
