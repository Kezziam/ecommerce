package cigma.mini.project.ecommerce.controller.impl;

import cigma.mini.project.ecommerce.controller.ArticleController;
import cigma.mini.project.ecommerce.model.vo.ArticleVo;
import cigma.mini.project.ecommerce.sevices.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
@CrossOrigin
public class ArticleControllerImpl implements ArticleController {
    @Override
    public List<ArticleVo> getAllArticle() {
        return null;
    }

    @Autowired
    private ArticleService articleService;

    @Override
    @GetMapping("/article_description")
    public List<ArticleVo> getArticleByDescriptionLike(@RequestParam(name = "word") String word) {
        return this.articleService.findByDescriptionLike(word);
    }

    @Override
    public ArticleVo getArticleByReference(String reference) {
        return this.articleService.findByReference(reference);
    }


    @Override
    @PostMapping("/save")
    public ArticleVo saveArticle(@RequestBody ArticleVo articleVo) {
        return this.articleService.save(articleVo);
    }

    @Override
    @PutMapping("/update")
    public ArticleVo updateArticle(@RequestBody ArticleVo articleVo) {
        return this.articleService.update(articleVo);
    }

    @Override
    @DeleteMapping("/delete")
    public boolean deleteArticle(@RequestBody ArticleVo articleVo) {
        return this.articleService.delete(articleVo);
    }
}
