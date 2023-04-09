package cigma.mini.project.ecommerce.controller;

import cigma.mini.project.ecommerce.model.vo.BasketVo;
import cigma.mini.project.ecommerce.model.vo.OrderLineVo;

import java.util.List;

public interface ClientController {

    List<BasketVo> findAllBasket();

    BasketVo getBasketById(Long id);

    BasketVo updateBasket(BasketVo basketVo);

    OrderLineVo getOrderLineById(Long id);

    List<OrderLineVo> getAllOrderLine();

    OrderLineVo saveOrderLine(OrderLineVo orderLineVo);

    OrderLineVo updateOrderLine(OrderLineVo orderLineVo);

    boolean deleteOrderLine(OrderLineVo orderLineVo);

    boolean deleteAllOrderLineArticleOfClientByClientId(long idClient);
}
