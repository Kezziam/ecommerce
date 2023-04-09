package cigma.mini.project.ecommerce.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections.CollectionUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "BASKET")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Basket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "basket")
    private List<OrderLine> orderLines;

    @Column(name = "PRICE_TOTAL")
    private Double priceTotal;

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", priceTotal=" + priceTotal +
                '}';
    }
}
