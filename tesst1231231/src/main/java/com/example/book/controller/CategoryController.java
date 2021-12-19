package com.example.book.controller;

import com.example.book.dto.CategoryDTO;
import com.example.book.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @PostMapping
    public CategoryDTO addCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        return categoryService.saveCategory(categoryDTO);
    }
    @GetMapping
    public List<CategoryDTO> getCategories() {
        return categoryService.getCategories();
    }
    @GetMapping("/{maTL}")
    public CategoryDTO findCategory(@PathVariable String maTL) {
        return categoryService.getCategory(maTL);
    }

    @PutMapping("/{maTL}")
    public CategoryDTO updateCategory(@Valid @RequestBody CategoryDTO categoryDTO, @PathVariable String maTL) {
        categoryDTO.setMaTL(maTL);
        return categoryService.updateCategory(categoryDTO);
    }

    @DeleteMapping("/{maTL}")
    public void deleteCategory(@PathVariable String maTL) {
        categoryService.deleteCategory(maTL);
    }
}
