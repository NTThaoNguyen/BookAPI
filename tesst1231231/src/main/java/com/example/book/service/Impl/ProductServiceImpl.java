package com.example.book.service.Impl;

import com.example.book.dto.ProductDTO;
import com.example.book.entity.*;
import com.example.book.exception.NotFoundException;
import com.example.book.repository.AuthorRepository;
import com.example.book.repository.CategoryRepository;
import com.example.book.repository.NXBRepository;
import com.example.book.repository.ProductRepository;
import com.example.book.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    NXBRepository nxbRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {
        Category category = categoryRepository.getById(productDTO.getCategoryId());
        Author author = authorRepository.getById(productDTO.getIdTG());
        NXB nxb = nxbRepository.getById(productDTO.getIdNXB());
        Product product = productDTO.toEntity();
        product.setCategory(category);
        product.setAuthor(author);
        product.setNxb(nxb);
        Product savedProduct = productRepository.save(product);
        return new ProductDTO(savedProduct);
    }

    @Override
    public List<ProductDTO> getProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getProductsByCategoryId(String categoryId) {
        List<Product> products = productRepository.findByCategory_MaTL(categoryId);
        return products.stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProduct(long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not exists"));
        return new ProductDTO(product);
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO) {
        Category category = categoryRepository.getById(productDTO.getCategoryId());
        Author author = authorRepository.getById(productDTO.getIdTG());
        NXB nxb = nxbRepository.getById(productDTO.getIdNXB());
//        Product product = productRepository.getById(productDTO.getId());
        Product product = productRepository.findById(productDTO.getId()).orElseThrow(()-> new NotFoundException("Not found with id: "+productDTO.getId()));
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        product.setDescription(productDTO.getDescription());
        product.setStatus(productDTO.getStatus());
        product.setCategory(category);
        product.setAuthor(author);
        product.setNxb(nxb);
        Product savedProduct = productRepository.save(product);
        return new ProductDTO(savedProduct);
    }

    @Override
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }
}
