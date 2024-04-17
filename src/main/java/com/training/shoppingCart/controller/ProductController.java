package com.training.shoppingCart.controller;

import com.training.shoppingCart.DTO.ProductDto;
import com.training.shoppingCart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/api")
public class ProductController {
    @Autowired
    private  ProductService productService;

    @GetMapping("/{id}/statistics")
    public ResponseEntity<ProductDto> getProductStatistics(@PathVariable Integer id) {

        ProductDto productDto = productService.getStatistics(id);


        return ResponseEntity.ok(productDto);
    }
}
