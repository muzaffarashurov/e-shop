package uz.brogrammers.eshop.product.rest.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.brogrammers.eshop.product.model.ProductModel;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class ProductResponse {

    private Integer id;
    private String title;
    private BigDecimal price;
    private Integer categoryId;
    private String imageUrl;

}
