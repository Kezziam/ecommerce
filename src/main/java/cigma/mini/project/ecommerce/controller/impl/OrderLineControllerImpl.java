package cigma.mini.project.ecommerce.controller.impl;

import cigma.mini.project.ecommerce.controller.OrderLineController;
import cigma.mini.project.ecommerce.model.vo.OrderLineVo;
import cigma.mini.project.ecommerce.sevices.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderLine")
@CrossOrigin
public class OrderLineControllerImpl implements OrderLineController {

    @Autowired
    private OrderLineService orderLineService;

    @Override
    @GetMapping("/order_id")
    public OrderLineVo getOrderLineById(@RequestParam(name = "id") Long id) {
        return this.orderLineService.findById(id);
    }

    @Override
    @GetMapping("/admin/order_line")
    public List<OrderLineVo> getAllOrderLine() {
        return this.orderLineService.findAll();
    }

    @Override
    @PostMapping("/save")
    public OrderLineVo saveOrderLine(@RequestBody OrderLineVo orderLineVo) {
        return this.orderLineService.save(orderLineVo);
    }

    @Override
    @PutMapping("/update")
    public OrderLineVo updateOrderLine(@RequestBody OrderLineVo orderLineVo) {
        return this.orderLineService.update(orderLineVo);
    }

    @Override
    @DeleteMapping("/delete")
    public boolean deleteOrderLine(@RequestBody OrderLineVo orderLineVo) {
        return this.orderLineService.delete(orderLineVo);
    }

    @Override
    @DeleteMapping("/delete/AllOrderLineArticleOfClient")
    public boolean deleteAllOrderLineArticleOfClientByClientId(@RequestParam(name = "idClient") long idClient) {
        return this.orderLineService.deleteByClientId(idClient);
    }
}
