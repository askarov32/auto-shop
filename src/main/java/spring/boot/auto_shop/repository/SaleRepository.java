package spring.boot.auto_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.boot.auto_shop.models.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}
