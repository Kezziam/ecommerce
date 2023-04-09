package cigma.mini.project.ecommerce.sevices.impl;

import cigma.mini.project.ecommerce.doa.BasketRepository;
import cigma.mini.project.ecommerce.model.Basket;
import cigma.mini.project.ecommerce.model.vo.BasketVo;
import cigma.mini.project.ecommerce.sevices.BasketService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("basketService")
public class BasketServiceImpl implements BasketService {

    private final Logger log = Logger.getLogger(BasketServiceImpl.class);
    @Autowired
    private BasketRepository basketRepository;

    @Override
    public List<BasketVo> findAll() {
        return BasketVo.toListVo(this.basketRepository.findAll());
    }

    @Override
    public BasketVo findById(Long id) {
        Basket basket = this.basketRepository.findById(id).isPresent()? this.basketRepository.findById(id).get(): new Basket();
        return BasketVo.toVo(basket);
    }

    @Override
    public BasketVo save(BasketVo basketVo) {
        return BasketVo.toVo(this.basketRepository.save(BasketVo.toBo(basketVo)));
    }

    @Override
    public BasketVo update(BasketVo basketVo) {
        return BasketVo.toVo(this.basketRepository.save(BasketVo.toBo(basketVo)));
    }

    @Override
    public boolean delete(BasketVo basketVo) {
        try {
            this.basketRepository.delete(BasketVo.toBo(basketVo));
            return true;
        } catch (Exception e) {
           log.error(e,e);
            return false;
        }

    }

}
