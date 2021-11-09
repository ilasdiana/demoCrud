package demo.demo.democrudapp.controller;

import demo.demo.democrudapp.model.Product;
import demo.demo.democrudapp.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> readAllProducts() {
        List<Product> productList = productService.getAllProducts();
        return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
    }

}
