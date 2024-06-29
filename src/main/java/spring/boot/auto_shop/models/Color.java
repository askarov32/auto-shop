package spring.boot.auto_shop.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "colors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Color {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
}
