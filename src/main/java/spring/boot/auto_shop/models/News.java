package spring.boot.auto_shop.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "news")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class News {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "photo")
    private String photo;
    @ManyToOne
    @JoinColumn
    private Car car;

}
