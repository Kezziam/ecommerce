package cigma.mini.project.ecommerce.doa;

import cigma.mini.project.ecommerce.model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Long> {
}
