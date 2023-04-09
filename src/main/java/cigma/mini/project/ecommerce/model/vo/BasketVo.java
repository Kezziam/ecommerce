package cigma.mini.project.ecommerce.model.vo;

import cigma.mini.project.ecommerce.model.Basket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasketVo {

    private Long id;
    private List<OrderLineVo> orderLineVos;
    private Double priceTotal;

    public static BasketVo toVo(Basket basket) {
        if (basket == null || basket.getId() == null) return null;

        BasketVo basketVo = new BasketVo();
        basketVo.setId(basket.getId());
        basketVo.setOrderLineVos(OrderLineVo.toListVo(basket.getOrderLines()));
        basketVo.setPriceTotal(basket.getPriceTotal());

        return basketVo;
    }

    public static Basket toBo(BasketVo basketVo) {
        if (basketVo == null || basketVo.getId() == null) return null;
        Basket basket = new Basket();
        basket.setId(basketVo.getId());
        basket.setOrderLines(OrderLineVo.toListBo(basketVo.getOrderLineVos()));
        basketVo.setPriceTotal(basket.getPriceTotal());

        return basket;
    }

    public static List<BasketVo> toListVo(List<Basket> baskets) {
        if (CollectionUtils.isEmpty(baskets)) return Collections.emptyList();

        List<BasketVo> basketVos = new ArrayList<>();
        baskets.forEach(el -> basketVos.add(toVo(el)));
        return basketVos;
    }

    public static List<Basket> toListBo(List<BasketVo> basketVos) {
        if (CollectionUtils.isEmpty(basketVos)) return Collections.emptyList();

        List<Basket> baskets = new ArrayList<>();
        basketVos.forEach(el -> baskets.add(toBo(el)));
        return baskets;
    }

}
