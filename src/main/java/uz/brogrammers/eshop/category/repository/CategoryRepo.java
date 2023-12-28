package uz.brogrammers.eshop.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.brogrammers.eshop.category.entity.Category;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
