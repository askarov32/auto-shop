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

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "volume")
    private int volume;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "photo")
    private String photo;

    @Column(name = "price")
    private int price;

    @Column(name = "mileage")
    private int mileage;


}
