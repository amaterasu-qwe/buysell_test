package com.project.buysell.services;

import com.project.buysell.models.Product;
import com.project.buysell.repositoires.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    private List<Product> products = new ArrayList<>();
    private long ID = 0;

    {
        products.add(new Product(++ID, "PlayStation 5", "Simple description", 67000, "Krasnoyarsk", "Vova"));
        products.add(new Product(++ID,"Iphone 8", "Simple description", 24000, "Moscow", "Gosha"));
    }

    public List<Product> list (String title){
        if (title != null) return productRepository.findByTitle(title);
        return productRepository.findAll();
    }

    public Product getProductById (Long id) {

        return productRepository.findById(id).orElse(null);
    }

    public void saveProduct (Product product) {
        productRepository.save(product);
    }

    public void deleteProduct (Long id) {
        productRepository.deleteById(id);
    }
}
