package javier.inventory.services;

import javier.inventory.models.Product;

import java.util.List;

public interface iProductService {
    public List<Product> listProducts();

    public Product searchProductById(Integer id);

    public Product saveProduct(Product product);

    public void deleteProductById(Integer id);
}
