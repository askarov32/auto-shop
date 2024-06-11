package spring.boot.auto_shop.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "news")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class News {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "author")
    private String author;

    @Column(name = "date")
    private String date;

    @Column(name = "comment")
    private String comment;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "photo")
    private String photo;

}
