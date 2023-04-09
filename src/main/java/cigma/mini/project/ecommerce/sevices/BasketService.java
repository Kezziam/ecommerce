package cigma.mini.project.ecommerce.sevices;

import cigma.mini.project.ecommerce.model.vo.BasketVo;

import java.util.List;

public interface BasketService {

    List<BasketVo> findAll();

    BasketVo findById(Long id);

    BasketVo save(BasketVo basketVo);

    BasketVo update(BasketVo basketVo);

    boolean delete(BasketVo basketVo);

}
