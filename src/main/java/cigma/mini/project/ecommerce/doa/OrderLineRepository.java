package cigma.mini.project.ecommerce.doa;

import cigma.mini.project.ecommerce.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {

    List<OrderLine> findByArticleId(Long idArticle);

    @Query("select o from OrderLine o " +
            "where o.article.reference=:refArticle")
    List<OrderLine> findByReference(@Param("refArticle") String refArticle);

    List<OrderLine> findByClientId(Long idClient);

    void deleteByClientId(Long idClient);
}
