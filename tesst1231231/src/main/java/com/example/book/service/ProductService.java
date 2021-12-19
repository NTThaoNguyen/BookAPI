package com.example.book.service;


import com.example.book.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    public ProductDTO saveProduct(ProductDTO productDTO);
    public List<ProductDTO> getProducts();
    public List<ProductDTO> getProductsByCategoryId(String categoryId);
    public ProductDTO getProduct(long id);
    public ProductDTO updateProduct(ProductDTO productDTO);
    public void deleteProduct(long id);

}
