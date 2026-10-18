package com.learning.springboot.proxyServiceDemo.service.impl;

import com.learning.springboot.proxyServiceDemo.dto.CartResponseDto;
import com.learning.springboot.proxyServiceDemo.dto.ProductRequestDto;
import com.learning.springboot.proxyServiceDemo.dto.ProductResponseDto;
import com.learning.springboot.proxyServiceDemo.service.FakeStoreApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class FakeStoreApiServiceImpl implements FakeStoreApiService {

    private RestClient restClient;

    @Value("${external.api.base-url}")
    private String baseUrl;

    @Autowired
    public FakeStoreApiServiceImpl(RestClient restClient){
        this.restClient = restClient;
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        return restClient.get()
                .uri(baseUrl + "/products")
                .retrieve()
                .body(new ParameterizedTypeReference<List<ProductResponseDto>>() {});
    }

    @Override
    public ProductResponseDto getProductById(int id) {
        return restClient.get()
                .uri(baseUrl + "/products/" + id)
                .retrieve()
                .body(ProductResponseDto.class);
    }

    @Override
    public ProductResponseDto updateProductById(int id, ProductRequestDto productRequestDto) {
        return  restClient.put()
                .uri(baseUrl + "/products/" + id)
                .body(productRequestDto)
                .retrieve()
                .body(ProductResponseDto.class);
    }

    @Override
    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) {
        return restClient.post()
                .uri(baseUrl + "/products")
                .body(productRequestDto)
                .retrieve()
                .body(ProductResponseDto.class);
    }

    @Override
    public ProductResponseDto deleteProduct(int id) {
        return restClient.delete()
                .uri(baseUrl + "/products/" + id)
                .retrieve()
                .body(ProductResponseDto.class);
    }

    @Override
    public List<CartResponseDto> getAllCarts() {
        return restClient.get()
                .uri(baseUrl + "/carts")
                .retrieve()
                .body(new ParameterizedTypeReference<List<CartResponseDto>>() {});
    }

    @Override
    public CartResponseDto getCartById(int id) {
        return restClient.get()
                .uri(baseUrl + "/carts/" + id)
                .retrieve()
                .body(CartResponseDto.class);
    }
}
