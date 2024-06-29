package spring.boot.auto_shop.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "car_bodies")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CarBody {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
}
