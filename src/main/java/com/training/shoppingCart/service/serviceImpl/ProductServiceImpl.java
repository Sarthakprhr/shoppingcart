package com.training.shoppingCart.service.serviceImpl;

import com.training.shoppingCart.model.Product;
import com.training.shoppingCart.repository.ProductRepo;
import com.training.shoppingCart.requestWrapper.ProductRequestWrapper;
import com.training.shoppingCart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private  ProductRepo productRepository;
    @Override
    public void addProduct(ProductRequestWrapper request) {
        // Convert ProductRequestWrapper to Product entity
        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());

        // Save the product to the database
        productRepository.save(product);

        // You may want to add additional error handling and logging here
    }

    public void updateProduct(ProductRequestWrapper request, Integer id) {
        // Find the existing product by ID
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        // Update product attributes
        existingProduct.setName(request.getName());
        existingProduct.setPrice(request.getPrice());

        // Save the updated product back to the database
        productRepository.save(existingProduct);
    }
}

