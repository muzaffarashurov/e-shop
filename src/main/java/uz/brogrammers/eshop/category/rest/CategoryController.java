package uz.brogrammers.eshop.category.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.brogrammers.eshop.category.entity.Category;
import uz.brogrammers.eshop.category.service.CategoryService;

import java.util.List;
@Tag(name = "Category")
@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @Operation(summary = "Get all categories")
    @GetMapping("/")
    public List<Category> getAll() {
        return categoryService.findAll();
    }
}
