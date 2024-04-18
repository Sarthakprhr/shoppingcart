package com.training.shoppingCart.service.serviceImpl;

import com.training.shoppingCart.DTO.ProductDto;
import com.training.shoppingCart.model.Product;
import com.training.shoppingCart.repository.ProductRepo;
import com.training.shoppingCart.requestWrapper.ProductRequestWrapper;
import com.training.shoppingCart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<ProductDto> getAllProduct() {
     List<Product> products= productRepository.findAll();

     List<ProductDto> productDtos = new ArrayList<>();
     for(Product product : products)
     {
         ProductDto dto= new ProductDto();
         dto.setProductId(product.getProductId());
         dto.setName(product.getName());
         dto.setPrice(product.getPrice());
         dto.setExpiryDate(product.getExpiryDate());
         dto.setManufacturerName(product.getManufacturerName());
         dto.setSoldUnits(product.getSoldUnits());
         dto.setRating(product.getRating());

         productDtos.add(dto);
     }
return productDtos;
    }

    public void updateProduct(ProductRequestWrapper request, Integer id) {


            Product existingProduct = productRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        if(existingProduct.getUsers().getRoles()=="admin") {

       existingProduct.setName(request.getName());
       existingProduct.setPrice(request.getPrice());


       productRepository.save(existingProduct);
   }

    }

    @Override
    public void deleteProduct(Integer id) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        productRepository.delete(existingProduct);
    }

    @Override
    public ProductDto getStatistics(Integer id) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        ProductDto productDto = new ProductDto();
        productDto.setName(existingProduct.getName());
        productDto.setProductId(existingProduct.getProductId());
        productDto.setPrice(existingProduct.getPrice());
        productDto.setRating(existingProduct.getRating());
        productDto.setExpiryDate(existingProduct.getExpiryDate());
        productDto.setSoldUnits(existingProduct.getSoldUnits());
        productDto.setManufacturerName(existingProduct.getManufacturerName());

        return productDto;
    }


}

