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

    @PostMapping
    public ResponseEntity<?> createproduct(@RequestBody Product product) {
        productService.insertProduct(product);
        return ResponseEntity.ok("Producto insertado");
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<List<Product>>(productService.getProducts(), HttpStatus.OK);

    }

    @GetMapping(value="/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable("productId") Integer productId){
        return new ResponseEntity<Product>(productService.getProductById(productId),HttpStatus.OK);
    }

    @PutMapping(value="/{productId}")
    public ResponseEntity<?> updateProduct(@PathVariable("productId") Integer productId, @RequestBody Product product){
        productService.updateProduct(productId,product);
        return ResponseEntity.ok("Producto actualizado");
    }

    @DeleteMapping(value="/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable("productId") Integer productId){
        productService.deleteProduct(productId);
        return ResponseEntity.ok("Producto eliminado");
    }

}
