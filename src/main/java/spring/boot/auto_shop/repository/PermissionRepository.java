package spring.boot.auto_shop.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.boot.auto_shop.models.Permission;


@Repository
@Transactional
public interface PermissionRepository extends JpaRepository<Permission, Integer> {

}
