package springsecurity.demo.service;


import org.springframework.security.core.userdetails.UserDetailsService;

import springsecurity.demo.entity.User;
import springsecurity.demo.user.CrmUser;

public interface UserService extends UserDetailsService {

    User findByUserName(String userName);

    void save(CrmUser crmUser);
}
