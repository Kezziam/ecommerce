package cigma.mini.project.ecommerce.sevices.impl;

import cigma.mini.project.ecommerce.doa.ClientRepository;
import cigma.mini.project.ecommerce.model.Client;
import cigma.mini.project.ecommerce.model.vo.BasketVo;
import cigma.mini.project.ecommerce.model.vo.ClientVo;
import cigma.mini.project.ecommerce.sevices.BasketService;
import cigma.mini.project.ecommerce.sevices.ClientService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("clientService")
public class ClientServiceImpl implements ClientService {

    private final Logger log = Logger.getLogger(ClientServiceImpl.class);
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private BasketService basketService;

    //todo inject Bcrypt password

    @Override
    public ClientVo findClientByUsername(String username) {
        Optional<Client> clientOptional = this.clientRepository.findClientByUsername(username);
        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
            return ClientVo.toVo(client);
        }
        return null;
    }

    @Override
    public ClientVo save(ClientVo clientVo) {
        //save new basket for new client
        BasketVo basketVo = new BasketVo();
        basketVo.setPriceTotal(0d);
        basketVo = this.basketService.save(basketVo);

        //set basket that saved
        clientVo.setBasketVo(basketVo);
        //todo crypto password
        Client client = this.clientRepository.save(ClientVo.toBo(clientVo));
        return ClientVo.toVo(client);
    }

    @Override
    public ClientVo update(ClientVo clientVo) {
        Client client = this.clientRepository.save(ClientVo.toBo(clientVo));
        return ClientVo.toVo(client);
    }

    @Override
    public boolean delete(ClientVo clientVo) {
        try {
            this.clientRepository.delete(ClientVo.toBo(clientVo));
            return true;
        } catch (Exception e) {
            log.error(e, e);
            return false;
        }
    }
}
