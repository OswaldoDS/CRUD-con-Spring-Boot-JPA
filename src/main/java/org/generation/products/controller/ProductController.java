package org.generation.products.controller;

import org.generation.products.model.Product;
import org.generation.products.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //Metodo GET para visualizar todos los productos
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    //Metodo POST para crear un nuevo producto
    @PostMapping("/new")
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    //Metodo PUT para modificar todo un producto
//    @PutMapping


    //Metodo DELETE para eliminar producto
    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        if (!productService.verifyId(id)) {
            throw new RuntimeException("Id: " + id + " no encontrado");
        }
        productService.deleteProduct(id);
    }

}
