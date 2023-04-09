package cigma.mini.project.ecommerce.controller;

import cigma.mini.project.ecommerce.model.vo.OrderLineVo;

import java.util.List;

public interface OrderLineController {

    OrderLineVo getOrderLineById(Long id);

    List<OrderLineVo> getAllOrderLine();

    OrderLineVo saveOrderLine(OrderLineVo orderLineVo);

    OrderLineVo updateOrderLine(OrderLineVo orderLineVo);

    boolean deleteOrderLine(OrderLineVo orderLineVo);

    boolean deleteAllOrderLineArticleOfClientByClientId(long idClient);

//    List<OrderLineVo> findByReference(String refArticle);
//     List<OrderLineVo> findByArticleId(Long idArticle);
//    boolean isArticleSelectedInBasket(Long idArticle);
//    boolean isArticleSelectedInBasket(String refArticle);

}
