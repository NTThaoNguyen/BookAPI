package com.example.book.dto;

import com.example.book.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO {
    private Long maTG;
    private String tenTG;
    public AuthorDTO(Author author) {
        this.maTG= author.getMaTG();
        this.tenTG= author.getTenTG();
    }
    public Author toEntity() {
        Author author = new Author();
        if (this.maTG != null) { // must has id to update
            author.setMaTG(this.maTG);
        }
        author.setTenTG(this.tenTG);
        return author;
    }
}
