package com.learning.springboot.proxyServiceDemo.service;

import com.learning.springboot.proxyServiceDemo.dto.CartResponseDto;
import com.learning.springboot.proxyServiceDemo.dto.ProductRequestDto;
import com.learning.springboot.proxyServiceDemo.dto.ProductResponseDto;

import java.util.List;

public interface FakeStoreApiService {
    List<ProductResponseDto> getAllProducts();

    ProductResponseDto getProductById(int id);

    ProductResponseDto updateProductById(int id, ProductRequestDto productRequestDto);

    ProductResponseDto addProduct(ProductRequestDto productRequestDto);

    ProductResponseDto deleteProduct(int id);

    List<CartResponseDto> getAllCarts();

    CartResponseDto getCartById(int id);
}
