package cigma.mini.project.ecommerce.sevices;

import cigma.mini.project.ecommerce.model.vo.OrderLineVo;

import java.util.List;

public interface OrderLineService {

    OrderLineVo findById(Long id);

    List<OrderLineVo> findAll();

    OrderLineVo save(OrderLineVo orderLineVo);

    OrderLineVo update(OrderLineVo orderLineVo);

    boolean delete(OrderLineVo orderLineVo);

    boolean isArticleSelectedInBasket(Long idArticle);

    boolean isArticleSelectedInBasket(String refArticle);

    List<OrderLineVo> findByArticleId(Long idArticle);

    List<OrderLineVo> findByReference(String refArticle);

    boolean deleteByClientId(long idClient);


}
