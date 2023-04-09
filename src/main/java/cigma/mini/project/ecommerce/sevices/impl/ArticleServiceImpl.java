package cigma.mini.project.ecommerce.sevices.impl;

import cigma.mini.project.ecommerce.doa.ArticleRepository;
import cigma.mini.project.ecommerce.model.Article;
import cigma.mini.project.ecommerce.model.vo.ArticleVo;
import cigma.mini.project.ecommerce.sevices.ArticleService;
import cigma.mini.project.ecommerce.sevices.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private OrderLineService orderLineService;

    @Override
    public ArticleVo findByReference(String reference) {
        Article article= this.articleRepository.findByReference(reference);
        return ArticleVo.toVo(article);
    }

    @Override
    public List<ArticleVo> findByDescriptionLike(String word) {
        return ArticleVo.toListVo(articleRepository.findByDescriptionLike(word));
    }

    @Override
    public List<ArticleVo> findAll() {
        return ArticleVo.toListVo(articleRepository.findAll());
    }

    @Override
    public ArticleVo save(ArticleVo articleVo) {
        Article article= ArticleVo.toBo(articleVo);
        assert article != null;
        return ArticleVo.toVo(this.articleRepository.save(article));
    }

    @Override
    public ArticleVo update(ArticleVo articleVo) {
        Article article= ArticleVo.toBo(articleVo);
        assert article != null;
        return ArticleVo.toVo(this.articleRepository.save(article));
    }

    @Override
    public boolean delete(ArticleVo articleVo) {
        Article article= ArticleVo.toBo(articleVo);
        boolean deleted =false;
        assert article != null;
        if(this.orderLineService.isArticleSelectedInBasket(article.getId())){
            this.articleRepository.delete(article);
            deleted=true;
        }
        return deleted;
    }
}
