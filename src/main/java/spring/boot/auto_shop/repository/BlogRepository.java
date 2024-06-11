package spring.boot.auto_shop.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.boot.auto_shop.models.News;

@Repository
@Transactional
public interface BlogRepository extends JpaRepository<News, Integer> {

}
