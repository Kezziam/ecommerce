package cigma.mini.project.ecommerce.sevices;

import cigma.mini.project.ecommerce.model.Client;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public interface UserService extends UserDetailsService {

    @Override
    Client loadUserByUsername(String username) throws UsernameNotFoundException;
}
