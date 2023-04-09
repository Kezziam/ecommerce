package cigma.mini.project.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "CLIENT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "FIRSTNAME")
    private String firstName;
    @Column(name = "LASTNAME")
    private String lastName;
    @Column(name = "CITY")
    private String city;

    @Column(name = "NUMBER_PHONE", length = 13)
    @Pattern(regexp = "^\\++?\\d{12}")//+212665656565
    private String numberPhone;

    @Column(name = "MAIL", unique = true)
    @Email(
            regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.?[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$",
            message = "the mail not valid"
    )
    private String mail;

    @Column(name = "USERNAME", unique = true)
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "User_Role", joinColumns = @JoinColumn(name = "clien_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    //todo save basket auto retrun new basket(id,priceTotal)
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private Basket basket;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<OrderLine> orderLines;

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", numberPhone='" + numberPhone + '\'' +
                ", mail='" + mail + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
