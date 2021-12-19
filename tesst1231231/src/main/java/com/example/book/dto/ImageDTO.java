package com.example.book.dto;

import com.example.book.entity.Image;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImageDTO {
    private Long id;
    @NotBlank(message = "url must be not blank")
    private String url;

    public ImageDTO(Image image) {
        this.id = image.getId();
        this.url = image.getUrl();
    }

    public Image toEntity() {
        Image image = new Image();
        if(this.id != null) {
            image.setId(this.id);
        }
        image.setUrl(this.url);
        return image;
    }
}
