package cigma.mini.project.ecommerce.model.vo;

import cigma.mini.project.ecommerce.model.Article;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleVo {

    private Long id;
    private String reference;
    private String designation;
    private Double price;
    private int quantity;
    private String description;
    private Boolean selected;

    public static ArticleVo toVo(Article articleBo) {
        ArticleVo articleVo = new ArticleVo();
        if (articleBo == null || articleBo.getId() == null) return null;

        articleVo.setId(articleBo.getId());
        articleVo.setDescription(articleBo.getDescription());
        articleVo.setDesignation(articleBo.getDesignation());
        articleVo.setPrice(articleBo.getPrice());
        articleVo.setQuantity(articleBo.getQuantity());
        articleVo.setSelected(articleBo.getSelected());

        return articleVo;
    }

    public static Article toBo(ArticleVo articleVo) {
        Article articleBo = new Article();
        if (articleVo == null || articleVo.getId() == null) return null;

        articleBo.setId(articleVo.getId());
        articleBo.setDescription(articleVo.getDescription());
        articleBo.setDesignation(articleVo.getDesignation());
        articleBo.setPrice(articleVo.getPrice());
        articleBo.setQuantity(articleVo.getQuantity());
        articleBo.setSelected(articleVo.getSelected());

        return articleBo;
    }


    public static List<ArticleVo> toListVo(List<Article> articlesBo) {
        if (CollectionUtils.isEmpty(articlesBo)) return Collections.emptyList();
        List<ArticleVo> articlesVo = new ArrayList<>();
        articlesBo.forEach(el -> articlesVo.add(toVo(el)));
        return articlesVo;
    }

    public static List<Article> toListBo(List<ArticleVo> articlesVo) {
        if (CollectionUtils.isEmpty(articlesVo)) return Collections.emptyList();
        List<Article> articlesBo = new ArrayList<>();
        articlesVo.forEach(el -> articlesBo.add(toBo(el)));

        return articlesBo;
    }
}
