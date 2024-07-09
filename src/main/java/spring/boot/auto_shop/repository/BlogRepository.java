package spring.boot.auto_shop.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.boot.auto_shop.models.Blog;

import java.util.List;

@Repository
@Transactional
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    @Query("SELECT b FROM Blog b LEFT JOIN FETCH b.comments")
    List<Blog> findAllWithComments();

}
