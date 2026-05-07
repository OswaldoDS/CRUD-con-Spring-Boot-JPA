package org.generation.products.controller;

import org.generation.products.model.Product;
import org.generation.products.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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

    //Metodo GET para visualizar un producto por Id
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        if (!productService.verifyId(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id: " + id + " no encontrado");
        }
        return productService.getProductById(id);
    }

    //Metodo POST para crear un nuevo producto
    @PostMapping("/new")
    public Product postSaveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    //Metodo PUT para modificar todo un producto
    @PutMapping("/edit/{id}")
    public Product putEditProduct(@RequestBody Product product, @PathVariable Long id) {
        if (!productService.verifyId(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id: " + id + " no encontrado");
        }
        return productService.saveProduct(product);
    }


    //Metodo DELETE para eliminar producto
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        if (!productService.verifyId(id)) {
            return "Id: " + id + " no encontrado!";
        } else {
            productService.deleteProduct(id);
            return "Id: " + id + " eliminado con éxito!";
        }
    }

}
