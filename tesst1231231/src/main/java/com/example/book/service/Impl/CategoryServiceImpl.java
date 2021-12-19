package com.example.book.service.Impl;

import com.example.book.dto.CategoryDTO;
import com.example.book.entity.Category;
import com.example.book.exception.NotFoundException;
import com.example.book.repository.CategoryRepository;
import com.example.book.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public CategoryDTO saveCategory(CategoryDTO categoryDTO) {
        Category savedCategory = categoryRepository.save(categoryDTO.toEntity());
        return new CategoryDTO(savedCategory);
    }

    @Override
    public List<CategoryDTO> getCategories() {
        return categoryRepository.findAll().stream().map(CategoryDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategory(String maTl) {
        Category category = categoryRepository.findById(maTl).orElseThrow(() -> new NotFoundException("Category does not exists"));
        return new CategoryDTO(category);
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO) {
//        Category category = categoryRepository.findById(categoryDTO.getId()).get();
        Category category = categoryRepository.getById(categoryDTO.getMaTL());
        category.setName(categoryDTO.getName());
        Category savedCategory = categoryRepository.save(category);
        return new CategoryDTO(savedCategory);
    }

    @Override
    public void deleteCategory(String maTL) {
        categoryRepository.deleteById(maTL);
    }

}
