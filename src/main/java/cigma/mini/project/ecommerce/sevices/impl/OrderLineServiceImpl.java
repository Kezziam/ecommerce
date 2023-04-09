package cigma.mini.project.ecommerce.sevices.impl;

import cigma.mini.project.ecommerce.doa.OrderLineRepository;
import cigma.mini.project.ecommerce.model.OrderLine;
import cigma.mini.project.ecommerce.model.vo.OrderLineVo;
import cigma.mini.project.ecommerce.sevices.OrderLineService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("orderLineService")
public class OrderLineServiceImpl implements OrderLineService {

    private final Logger log = Logger.getLogger(OrderLineServiceImpl.class);
    @Autowired
    private OrderLineRepository orderLineRepository;

    @Override
    public OrderLineVo findById(Long id) {
        Optional<OrderLine> orderLineOptional = this.orderLineRepository.findById(id);
        OrderLine orderLine= new OrderLine();
        if (orderLineOptional.isPresent()) orderLine = orderLineOptional.get();
        return OrderLineVo.toVo(orderLine);
    }

    @Override
    public List<OrderLineVo> findAll() {
        return OrderLineVo.toListVo(this.orderLineRepository.findAll());
    }

    @Override
    public OrderLineVo save(OrderLineVo orderLineVo) {
       //todo find  basket of current client
        //get basket vo and convert it to bo
        //add basket to order line
        return OrderLineVo.toVo(this.orderLineRepository.save(OrderLineVo.toBo(orderLineVo)));
    }

    @Override
    public OrderLineVo update(OrderLineVo orderLineVo) {
        return OrderLineVo.toVo(this.orderLineRepository.save(OrderLineVo.toBo(orderLineVo)));
    }

    @Override
    public boolean delete(OrderLineVo orderLineVo) {
        try{
            this.orderLineRepository.delete(OrderLineVo.toBo(orderLineVo));
            return true;
        }catch (Exception e){
            log.error(e,e);
            return false;
        }
    }

    @Override
    public boolean isArticleSelectedInBasket(Long idArticle) {
        return CollectionUtils.isEmpty(this.findByArticleId(idArticle));
    }

    @Override
    public boolean isArticleSelectedInBasket(String refArticle) {
        return CollectionUtils.isEmpty(this.findByReference(refArticle));
    }

    @Override
    public List<OrderLineVo> findByArticleId(Long idArticle) {
        return OrderLineVo.toListVo(this.orderLineRepository.findByArticleId(idArticle));
    }

    @Override
    public List<OrderLineVo> findByReference(String refArticle) {
        return OrderLineVo.toListVo(this.orderLineRepository.findByReference(refArticle));
    }

    @Override
    public boolean deleteByClientId(long idClient) {
        try{
           this.orderLineRepository.deleteByClientId(idClient);
           return true;
        }catch(Exception e){
            log.error(e,e);
            return false;
        }

    }
}
