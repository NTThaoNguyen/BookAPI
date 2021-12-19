package com.example.book.service;

import com.example.book.dto.CategoryDTO;
import com.example.book.service.Impl.CategoryServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    public CategoryDTO saveCategory(CategoryDTO categoryDTO);
    public List<CategoryDTO> getCategories();
    public CategoryDTO getCategory(String maTL);
    public CategoryDTO updateCategory(CategoryDTO categoryDTO);
    public void deleteCategory(String maTL);
}
