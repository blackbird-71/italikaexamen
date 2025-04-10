package mx.italika.exam.italikaexam.controllers;

import mx.italika.exam.italikaexam.models.Product;
import mx.italika.exam.italikaexam.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping
    public ResponseEntity<List<Product>> getUsers(){
        return new ResponseEntity<List<Product>>(productService.getProducts(), HttpStatus.OK);

    }
   /*
    @GetMapping(value="/{product}")
    public ResponseEntity<Product> getProductByProductName(@PathVariable("product") String product){
        return new ResponseEntity<Product>(productService.getProductByProductName(username),HttpStatus.OK);
    }
    */

}
