package spring.boot.auto_shop.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "sales")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "car_id")
    private int carId;

    @Column(name = "price")
    private double price;

    @Column(name = "date_sold")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSold;

    @ManyToOne
    @JoinColumn(name = "car_id", insertable = false, updatable = false)
    private Car car;
}
