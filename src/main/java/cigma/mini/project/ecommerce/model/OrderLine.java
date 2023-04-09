package cigma.mini.project.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ORDER_LINE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderLine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "REF_ARTICLE", columnDefinition = "REFERENCE")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENT", referencedColumnName = "id")
    private Client client;

    @Column(name = "QUANTITY")
    private int quantity;

    @Column(name = "PRICE_TOTAL")
    private Double priceTotal;

    @ManyToOne
    @JoinColumn(name = "ID_BASKET", referencedColumnName = "id")
    private Basket basket;


}
