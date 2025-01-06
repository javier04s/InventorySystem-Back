package javier.inventory.controllers;

import javier.inventory.exception.ResourceNotFoundException;
import javier.inventory.models.Product;
import javier.inventory.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("inventory-app")
@CrossOrigin(value = "http://localhost:4200")
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    // URL Final (http://localhost:8080/inventory-app/products)
    @GetMapping("/products")
    public List<Product> getProducts() {
        List<Product> products = productService.listProducts();

        logger.info("Productos obtenidos:");
        products.forEach(product -> logger.info(product.toString()));

        return products;
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        logger.info("Producto a agregar: " + product);
        return productService.saveProduct(product);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Product product = this.productService.searchProductById(id);
        if (product != null)
            return ResponseEntity.ok(product);
        else
            throw new ResourceNotFoundException("No se encontro el producto con el ID: " + id);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product) {
        Product updatedProduct = this.productService.searchProductById(id);

        if (updatedProduct == null)
            throw new ResourceNotFoundException("No se encontro el producto con el ID: " + id);

        updatedProduct.setDescription(product.getDescription());
        updatedProduct.setPrice(product.getPrice());
        updatedProduct.setQuantity(product.getQuantity());

        this.productService.saveProduct(updatedProduct);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable int id) {
        Product deletedProduct = this.productService.searchProductById(id);

        if (deletedProduct == null)
            throw new ResourceNotFoundException("No se encontro el producto con el ID: " + id);

        this.productService.deleteProductById(deletedProduct.getProductId());
        Map<String, Boolean> response = new HashMap<>();
        response.put("eliminado", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }
}
