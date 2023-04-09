package cigma.mini.project.ecommerce.sevices;

import cigma.mini.project.ecommerce.model.vo.ClientVo;

public interface ClientService {

    ClientVo findClientByUsername(String username);

    ClientVo save(ClientVo clientVo);

    ClientVo update(ClientVo clientVo);

    boolean delete(ClientVo clientVo);




}
