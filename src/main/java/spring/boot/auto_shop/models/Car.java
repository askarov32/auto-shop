package spring.boot.auto_shop.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cars")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "year")
    private int year;

    @Column(name = "mileage")
    private int mileage;

    @Column(name = "transmission")
    private String transmission;

    @Column(name = "horsepower")
    private int hp;

    @Column(name = "price")
    private int price;

    @Column(name = "image")
    private String image;

    @Column(name = "rentOrSale")
    private String rentOrSale;

}
