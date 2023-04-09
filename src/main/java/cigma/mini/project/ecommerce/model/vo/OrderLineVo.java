package cigma.mini.project.ecommerce.model.vo;

import cigma.mini.project.ecommerce.model.OrderLine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineVo {

    private Long id;
    private ArticleVo articleVo;
    private ClientVo clientVo;
    private int quantity;
    private Double priceTotal;
    private BasketVo basketVo;

    public static OrderLineVo toVo(OrderLine orderLine) {
        if (orderLine == null || orderLine.getId() == null) return null;
        OrderLineVo orderLineVo = new OrderLineVo();
        orderLineVo.setId(orderLine.getId());
        orderLineVo.setArticleVo(ArticleVo.toVo(orderLine.getArticle()));
        orderLineVo.setClientVo(ClientVo.toVo(orderLine.getClient()));
        orderLineVo.setQuantity(orderLine.getQuantity());
        orderLineVo.setPriceTotal(orderLine.getPriceTotal());
        orderLineVo.setBasketVo(BasketVo.toVo(orderLine.getBasket()));
        return orderLineVo;
    }

    public static OrderLine toBo(OrderLineVo orderLineVo) {
        if (orderLineVo == null || orderLineVo.getId() == null) return null;
        OrderLine orderLine = new OrderLine();
        orderLine.setId(orderLineVo.getId());
        orderLine.setArticle(ArticleVo.toBo(orderLineVo.getArticleVo()));
        orderLine.setClient(ClientVo.toBo(orderLineVo.getClientVo()));
        orderLine.setQuantity(orderLineVo.getQuantity());
        orderLine.setPriceTotal(orderLineVo.getPriceTotal());
        orderLine.setBasket(BasketVo.toBo(orderLineVo.getBasketVo()));
        return orderLine;
    }

    public static List<OrderLineVo> toListVo(List<OrderLine> orderLines) {
        if (CollectionUtils.isEmpty(orderLines)) return Collections.emptyList();

        List<OrderLineVo> orderLineVos = new ArrayList<>();
        orderLines.forEach(el -> orderLineVos.add(toVo(el)));
        return orderLineVos;
    }

    public static List<OrderLine> toListBo(List<OrderLineVo> orderLineVos) {
        if (CollectionUtils.isEmpty(orderLineVos)) return Collections.emptyList();

        List<OrderLine> orderLines = new ArrayList<>();
        orderLineVos.forEach(el -> orderLines.add(toBo(el)));
        return orderLines;
    }


}
