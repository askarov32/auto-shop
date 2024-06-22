package spring.boot.auto_shop.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "blogs")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "author")
    private String author;

    @Column(name = "date")
    private String date;

    @Column(name = "title")
    private String title;

    @Column(length = 65535)
    private String content;

    @Column(name = "photo")
    private String photo;

    @Column(name = "category")
    private String category;

    @Column(name = "quote")
    private String quote;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Comment> comments;
}
