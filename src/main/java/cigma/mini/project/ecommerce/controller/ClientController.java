package cigma.mini.project.ecommerce.controller;

import cigma.mini.project.ecommerce.model.vo.BasketVo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/client")
@CrossOrigin
public interface ClientController {

    List<BasketVo> findAllBasket();

    BasketVo getBasketById(Long id);

    BasketVo updateBasket(BasketVo basketVo);
}
