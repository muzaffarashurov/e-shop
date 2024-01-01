package uz.brogrammers.eshop.category.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.brogrammers.eshop.category.entity.Category;
import uz.brogrammers.eshop.category.repository.CategoryRepo;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepo categoryRepo;

    public Optional<Category> findById(Integer id) {
        return categoryRepo.findById(id);
    }

}
