package com.learning.springboot.proxyServiceDemo.controllers;

import com.learning.springboot.proxyServiceDemo.dto.CartResponseDto;
import com.learning.springboot.proxyServiceDemo.dto.ProductRequestDto;
import com.learning.springboot.proxyServiceDemo.dto.ProductResponseDto;
import com.learning.springboot.proxyServiceDemo.service.FakeStoreApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FakeStoreApiController {

    private final FakeStoreApiService fakeStoreApiService;

    @Autowired
    public FakeStoreApiController(FakeStoreApiService fakeStoreApiService){
        this.fakeStoreApiService = fakeStoreApiService;
    }

    @GetMapping("/products")
    public List<ProductResponseDto> getAllProducts(){
        return fakeStoreApiService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public ProductResponseDto getProductById(@PathVariable int id){
        return fakeStoreApiService.getProductById(id);
    }

    @PutMapping("/products/{id}")
    public ProductResponseDto updateProductById(@PathVariable int id, @RequestBody ProductRequestDto productRequestDto){
        return fakeStoreApiService.updateProductById(id, productRequestDto);
    }

    @PostMapping("/products")
    public ProductResponseDto addProduct(@RequestBody ProductRequestDto productRequestDto){
        return fakeStoreApiService.addProduct(productRequestDto);
    }

    @DeleteMapping("/products/{id}")
    public  ProductResponseDto deleteProduct(@PathVariable int id){
        return fakeStoreApiService.deleteProduct(id);
    }

    @GetMapping("/carts")
    public List<CartResponseDto> getAllCarts(){
        return fakeStoreApiService.getAllCarts();
    }

    @GetMapping("/carts/{id}")
    public CartResponseDto getCartById(@PathVariable int id){
        return fakeStoreApiService.getCartById(id);
    }
}
