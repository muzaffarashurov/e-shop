package uz.brogrammers.eshop.product.model;

import lombok.Builder;
import lombok.Getter;
import uz.brogrammers.eshop.product.entity.Product;

import java.math.BigDecimal;

@Getter
@Builder
public class ProductModel {
    private Integer id;
    private String name;
    private BigDecimal price;
    private Integer categoryId;
    private String imageUrl;

}
