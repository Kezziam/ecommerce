package cigma.mini.project.ecommerce.controller.impl;

import cigma.mini.project.ecommerce.controller.ClientController;
import cigma.mini.project.ecommerce.model.vo.BasketVo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClientControllerImpl implements ClientController {



    @Override
    public List<BasketVo> findAllBasket() {
        return null;
    }

    @Override
    public BasketVo getBasketById(Long id) {
        return null;
    }

    @Override
    public BasketVo updateBasket(BasketVo basketVo) {
        return null;
    }

    @Override
    public boolean deleteBasket(BasketVo basketVo) {
        return false;
    }
}
