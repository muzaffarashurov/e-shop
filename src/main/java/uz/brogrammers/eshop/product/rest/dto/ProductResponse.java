package uz.brogrammers.eshop.product.rest.dto;

import lombok.Builder;
import lombok.Getter;
import uz.brogrammers.eshop.product.model.ProductModel;

import java.math.BigDecimal;

@Getter
@Builder
public class ProductResponse {

    private Integer id;
    private String name;
    private BigDecimal price;
    private Integer categoryId;
    private String imageUrl;

}
