package uz.brogrammers.eshop.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.brogrammers.eshop.product.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

}
