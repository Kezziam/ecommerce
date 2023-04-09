package cigma.mini.project.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ARTICLE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "REFERENCE", unique = true, updatable = false)
    private String reference;

    @Column(name = "DESIGNATION", unique = true)
    private String designation;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "QUANTITY")
    private int quantity;

    @Column(name = "DESCRIPTION", length = 255)
    private String description;

    @Column(name = "SELECTED", columnDefinition = "tinyint(0) default false")
    private Boolean selected;

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                ", designation='" + designation + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                ", selected=" + selected +
                '}';
    }
}
