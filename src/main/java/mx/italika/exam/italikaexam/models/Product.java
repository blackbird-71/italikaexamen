package mx.italika.exam.italikaexam.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer productId;
    private String productName;
    private String description;
    private Double price;
    private Integer stock;
}
