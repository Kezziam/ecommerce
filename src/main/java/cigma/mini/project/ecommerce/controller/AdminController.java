package cigma.mini.project.ecommerce.controller;

import cigma.mini.project.ecommerce.model.vo.ArticleVo;


public interface AdminController {

    ArticleVo saveArticle(ArticleVo articleVo);

    ArticleVo updateArticle(ArticleVo articleVo);

    boolean deleteArticle(ArticleVo articleVo);

}
