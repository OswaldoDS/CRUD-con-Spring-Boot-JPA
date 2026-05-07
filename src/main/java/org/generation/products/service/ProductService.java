package org.generation.products.service;

import org.generation.products.model.Product;
import org.generation.products.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //Metodo para encontrar todo los productos
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    //Metodo para guardar los productos
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    //Metodo para eliminar productos por id
    public void deleteProduct(Long id){ productRepository.deleteById(id);}

    //Metodo para verificar que existe el id
    public Boolean verifyId(Long id){ return productRepository.existsById(id);}
}
