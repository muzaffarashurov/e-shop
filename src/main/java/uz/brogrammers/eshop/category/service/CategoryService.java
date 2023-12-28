package uz.brogrammers.eshop.category.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.brogrammers.eshop.category.repository.CategoryRepo;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepo categoryRepo;

    public List<String> getCategories() {
        return categoryRepo.getCategories();
    } // <1>

}
