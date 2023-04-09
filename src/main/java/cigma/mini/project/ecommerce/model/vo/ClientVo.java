package cigma.mini.project.ecommerce.model.vo;

import cigma.mini.project.ecommerce.model.Basket;
import cigma.mini.project.ecommerce.model.Client;
import cigma.mini.project.ecommerce.model.Role;
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
public class ClientVo {

    private Long id;
    private String firstName;
    private String lastName;
    private String city;
    private String numberPhone;
    private String mail;
    private String username;
    private String password;
    private List<RoleVo> roleVos;
    private BasketVo basketVo;

    public static ClientVo toVo(Client client) {

        if (client == null || client.getId() == null) return null;

        ClientVo clientVo = new ClientVo();
        clientVo.setId(client.getId());
        clientVo.setFirstName(client.getFirstName());
        clientVo.setLastName(client.getLastName());
        clientVo.setCity(client.getCity());
        clientVo.setNumberPhone(client.getNumberPhone());
        clientVo.setMail(client.getMail());
        clientVo.setUsername(client.getUsername());
        clientVo.setPassword(client.getPassword());
        clientVo.setRoleVos(RoleVo.toListVo(client.getRoles()));
        clientVo.setBasketVo(BasketVo.toVo(client.getBasket()));

        return clientVo;
    }

    public static Client toBo(ClientVo clientVo) {
        if (clientVo == null || clientVo.getId() == null) return null;
        Client client = new Client();
        client.setId(clientVo.getId());
        client.setFirstName(clientVo.getFirstName());
        client.setLastName(clientVo.getLastName());
        client.setCity(clientVo.getCity());
        client.setNumberPhone(clientVo.getNumberPhone());
        client.setMail(clientVo.getMail());
        client.setUsername(clientVo.getUsername());
        client.setPassword(clientVo.getPassword());
        client.setRoles(RoleVo.toListBo(clientVo.getRoleVos()));
        client.setBasket(BasketVo.toBo(clientVo.getBasketVo()));

        return client;
    }

    public static List<ClientVo> toListVo(List<Client> clients) {
        if (CollectionUtils.isEmpty(clients)) return Collections.emptyList();

        List<ClientVo> clientVos = new ArrayList<>();
        clients.forEach(el -> clientVos.add(toVo(el)));
        return clientVos;

    }

    public static List<Client> toListBo(List<ClientVo> clientVos) {
        if (CollectionUtils.isEmpty(clientVos)) return Collections.emptyList();

        List<Client> clients = new ArrayList<>();
        clientVos.forEach(el -> clients.add(toBo(el)));
        return clients;

    }

}