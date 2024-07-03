package spring.boot.auto_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.boot.auto_shop.models.Review;

@Repository
@Transactional
public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
