package uz.brogrammers.eshop.product.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.brogrammers.eshop.product.entity.Product;
import uz.brogrammers.eshop.product.mapper.ProductMapper;
import uz.brogrammers.eshop.product.model.ProductModel;
import uz.brogrammers.eshop.product.repository.ProductRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo productRepo;

    public List<Product> findAll() {
        return productRepo.findAll();
    }

    public List<ProductModel> getAllProducts() {
        return productRepo.findAll().stream()
                .map(ProductMapper::mapToModel)
                .toList();
    }

    public void addProduct(ProductModel productModel) {
        var entity = ProductMapper.mapToEntity(productModel);
        productRepo.save(entity);
    }
}
