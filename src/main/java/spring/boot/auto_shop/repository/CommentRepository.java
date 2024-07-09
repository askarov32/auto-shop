package spring.boot.auto_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.boot.auto_shop.models.Comment;

@Repository
@Transactional
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
