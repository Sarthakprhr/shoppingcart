package com.training.shoppingCart.service;

import com.training.shoppingCart.DTO.ProductDto;
import com.training.shoppingCart.requestWrapper.ProductRequestWrapper;

import java.util.List;

public interface ProductService {

void addProduct(ProductRequestWrapper request);
void updateProduct(ProductRequestWrapper request , Integer id);
void deleteProduct(Integer id);
List<ProductDto> getAllProduct();
ProductDto getStatistics(Integer id);

}
