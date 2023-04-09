package cigma.mini.project.ecommerce.sevices;

import cigma.mini.project.ecommerce.model.vo.ArticleVo;

import java.util.List;

public interface ArticleService {

    ArticleVo findByReference(String reference);

    List<ArticleVo> findByDescriptionLike(String word);

    List<ArticleVo> findAll();

    ArticleVo save(ArticleVo articleVo);

    ArticleVo update(ArticleVo articleVo);

    boolean delete(ArticleVo articleVo);
}
