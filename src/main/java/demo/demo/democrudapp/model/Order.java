package demo.demo.democrudapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderId")
    private Long id;
    private String address;
    private Double totalPrice;
    private Date orderDate;

    @ManyToMany(mappedBy = "orderList", cascade = CascadeType.ALL)
    private List<Product> productList;

}
