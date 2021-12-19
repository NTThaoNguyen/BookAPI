package com.example.book.dto;

import com.example.book.entity.Product;
import com.example.book.entity.ProductStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;

    @NotBlank(message = "Name must be not blank")
    private String name;

    // @NotBlank(message = "Price must be not blank")
    @NotNull(message = "Price must be not blank")
    @Min(0)
    private Double price;

    @NotNull(message = "Quantity must be not blank")
    @Min(0)
    private Integer quantity;

    @NotBlank(message = "Description must be not blank")
    private String description;

    @NotNull(message = "Status must be not blank")
    private ProductStatus status;

    private LocalDateTime updatedDate;
    @NotBlank(message = "categoryId must be not blank")
    private String categoryId;
    @NotNull(message = "authorId must be not null")
    private Long idTG;
    @NotNull(message = "nxbId must be not null")
    private Long idNXB;

//    @Size(min = 1, max = 3)
//    private List<ImageDTO> images = new ArrayList<>();

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.quantity = product.getQuantity();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.status = product.getStatus();
        this.categoryId = product.getCategory().getMaTL();
        this.idTG = product.getAuthor().getMaTG();
        this.idNXB = product.getNxb().getMaNXB();
    }

    public Product toEntity() {
        Product product = new Product();
        if (this.id != null) { // must has id to update
            product.setId(this.id);
        }
        product.setName(this.name);
        product.setPrice(this.price);
        product.setQuantity(this.quantity);
        product.setDescription(this.description);
        product.setStatus(this.status);
        return product;
    }
}
