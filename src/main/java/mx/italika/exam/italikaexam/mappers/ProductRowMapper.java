package mx.italika.exam.italikaexam.mappers;

import mx.italika.exam.italikaexam.models.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setProductId(rs.getInt(1));
        product.setProductName(rs.getString(2));
        product.setDescription(rs.getString(3));
        product.setPrice(rs.getDouble(4));
        product.setStock(rs.getInt(5));

        return product;
    }
}
