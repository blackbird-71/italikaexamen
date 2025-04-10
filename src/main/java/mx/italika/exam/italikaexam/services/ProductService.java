package mx.italika.exam.italikaexam.services;



import mx.italika.exam.italikaexam.models.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Service
public class ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductService.class);

    //String jdbcUrl = "jdbc:sqlserver://localhost:1433;databaseName=store";
    String jdbcUrl = "jdbc:sqlserver://sqlserver:1433;databaseName=store;user=sa;password=OscarRuiz-71";
//    String user = "sa";
//    String password = "OscarRuiz-71";
    String query = "SELECT * from product";


    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();

        log.info("Conectando");
        try (Connection connection = DriverManager.getConnection(jdbcUrl)) {
            //try (Connection conn = DriverManager.getConnection(jdbcUrl)) {
            //    CallableStatement stmt = conn.prepareCall("{call sp_Productos_CRUD(?, ?, ?, ?, ?, ?)}");
            log.info("Conectado");

            Statement statement = connection.createStatement();

            boolean execute = statement.execute(query);
            log.info("Es resulSet : " + execute);
            //ResultSet rs= statement.executeQuery(query);
            ResultSet rs = statement.getResultSet();


            while (rs.next()) {
                log.info("\nId {} \tName {} \tDescription {} \tPrice {} \tStock {}",
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5)
                );
            }

            products = new ArrayList<>();

            while(rs.next()){

                var product = new Product();
                product.setProductId(rs.getInt(1));
                product.setProductName(rs.getString(2));
                product.setDescription(rs.getString(3));
                product.setPrice(rs.getDouble(4));
                product.setStock(rs.getInt(5));

                products.add(product);
            }

            products.forEach(product -> log.info(product.toString()));


            statement.close();

        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        log.info("Cerrada la conexión");

        return products;

    }

}
