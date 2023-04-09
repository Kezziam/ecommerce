package cigma.mini.project.ecommerce.controller;

import cigma.mini.project.ecommerce.model.vo.BasketVo;

import java.util.List;

public interface ClientController {

    List<BasketVo> findAllBasket();

    BasketVo getBasketById(Long id);

    BasketVo updateBasket(BasketVo basketVo);

    boolean deleteBasket(BasketVo basketVo);
}
