package com.example.book.dto;

import com.example.book.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private String maTL;
    private String name;

    public CategoryDTO(Category category) {
        this.maTL = category.getMaTL();
        this.name = category.getName();
    }

    public Category toEntity() {
        Category category = new Category();
        if (this.maTL != null) { // must has id to update
            category.setMaTL(this.maTL);
        }
        category.setName(this.name);
        return category;
    }
}


