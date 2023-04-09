package cigma.mini.project.ecommerce.controller;

import cigma.mini.project.ecommerce.model.vo.ArticleVo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public interface AdminController {

    ArticleVo saveArticle(ArticleVo articleVo);

    ArticleVo updateArticle(ArticleVo articleVo);

    boolean deleteArticle(ArticleVo articleVo);

}
