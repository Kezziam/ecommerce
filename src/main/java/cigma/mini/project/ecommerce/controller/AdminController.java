package cigma.mini.project.ecommerce.controller;

import cigma.mini.project.ecommerce.model.vo.ArticleVo;
import java.util.List;

public interface AdminController {

    List<ArticleVo> getAllArticle();

    List<ArticleVo> getArticleByDescriptionLike(String word);

    ArticleVo getArticleByReference(String reference);

    ArticleVo saveArticle(ArticleVo articleVo);

    ArticleVo updateArticle(ArticleVo articleVo);

    boolean deleteArticle(ArticleVo articleVo);

}
