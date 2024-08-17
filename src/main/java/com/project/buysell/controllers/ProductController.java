package com.project.buysell.controllers;

import com.project.buysell.models.Product;
import com.project.buysell.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String products (@RequestParam(name = "title", required = false) String title, Model model) {
        model.addAttribute("products", productService.list(title));
        return "products";
    }

    @GetMapping("/product/{id}")
    public String productInfo (@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "product-info";
    }

    @PostMapping("/product/create")
    public String createProduct (Product product) {
        productService.saveProduct(product);
        return "redirect:/";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct (@PathVariable Long id) {
        productService.deleteProduct(id);
        System.out.println("Deleting product with ID: " + id); // Логирование для проверки
        return "redirect:/";
    }
}
