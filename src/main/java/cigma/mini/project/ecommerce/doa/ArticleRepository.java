package cigma.mini.project.ecommerce.doa;

import cigma.mini.project.ecommerce.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    List<Article> findByDescriptionLike(String word);

    Article findByReference(String reference);

}

