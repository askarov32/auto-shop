package spring.boot.auto_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.boot.auto_shop.models.News;

public interface NewsRepository extends JpaRepository<News, Integer> {

}
