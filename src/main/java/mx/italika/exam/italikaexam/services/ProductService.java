package mx.italika.exam.italikaexam.services;



import mx.italika.exam.italikaexam.mappers.ProductRowMapper;
import mx.italika.exam.italikaexam.models.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final Logger log = LoggerFactory.getLogger(ProductService.class);

    public List<Product> getProducts() {

        List<Product> products = new ArrayList<>();

        products = jdbcTemplate.query(
                "EXEC sp_Productos_CRUD ?, NULL, NULL, NULL, NULL, NULL",
                new Object[]{"READ"},
                new ProductRowMapper()
        );

        return products;
    }

    public Product getProductById(Integer id) {
        Product producto = new Product();

        producto = jdbcTemplate.queryForObject(
                "EXEC sp_Productos_CRUD ?, ?, NULL, NULL, NULL, NULL",
                new Object[]{"READ", id},
                new ProductRowMapper()
        );

        return producto;
    }

    public int insertProduct(Product product) {
        return jdbcTemplate.update("EXEC sp_Productos_CRUD ?, NULL, ?, ?, ?, ?",
                new Object[]{"CREATE",product.getProductName(), product.getDescription(), product.getPrice(), product.getStock()}
                );
    }

    public int updateProduct(Integer productId, Product product) {
        return jdbcTemplate.update("EXEC sp_Productos_CRUD ?, ?, ?, ?, ?, ?",
                new Object[]{"UPDATE", productId, product.getProductName(), product.getDescription(), product.getPrice(), product.getStock()});
    }

    public int deleteProduct(Integer productId) {
        return jdbcTemplate.update("EXEC sp_Productos_CRUD ?, ?, NULL, NULL, NULL, NULL",
                new Object[]{"DELETE", productId});
    }

}
