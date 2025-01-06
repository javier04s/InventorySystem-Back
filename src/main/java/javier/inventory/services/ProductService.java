package javier.inventory.services;

import javier.inventory.models.Product;
import javier.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements iProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> listProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public Product searchProductById(Integer id) {
        return this.productRepository.findById(id).orElse(null);
    }

    @Override
    public Product saveProduct(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public void deleteProductById(Integer id) {
        this.productRepository.deleteById(id);
    }
}
