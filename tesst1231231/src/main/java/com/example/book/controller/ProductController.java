package com.example.book.controller;

import com.example.book.dto.ProductDTO;
import com.example.book.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<ProductDTO> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/products/{id}")
    public ProductDTO getProduct(@PathVariable long id) {
        return productService.getProduct(id);
    }

    @GetMapping("/product-categories/{categoryId}")
    public List<ProductDTO> getProductsByCategoryId(@PathVariable String categoryId) {
        return productService.getProductsByCategoryId(categoryId);
    }

    @PostMapping("/products")
    public ProductDTO addProduct(@Valid @RequestBody ProductDTO productDTO) {
        return productService.saveProduct(productDTO);
    }

    @PutMapping("/products/{id}")
    public ProductDTO updateProduct(@Valid @RequestBody ProductDTO productDTO, @PathVariable long id) {
        productDTO.setId(id);
        return productService.updateProduct(productDTO);
    }

    @DeleteMapping("/products/{id}")
    public void deleteCategory(@PathVariable int id) {
        productService.deleteProduct(id);
    }
}
