package com.ae.user.authentication.entities.user.service;

import com.ae.user.authentication.entities.user.repository.UserRepository;
import com.ae.user.authentication.entity.RoleEntity;
import com.ae.user.authentication.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.ArrayList;
import java.util.List;


@Service("jpaUserDetailService")
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    private final Logger logger = LoggerFactory.getLogger(UserDetailService.class);

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity user =  repository.findByUsername(s);

        if (user == null) {
            logger.error("Error login: No existe el usuario: " + s);
            throw new UsernameNotFoundException("User no existe");
        }

        List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();

        for (RoleEntity role: user.getRoles()) {
            grantedAuthorityList.add(new SimpleGrantedAuthority(role.getAuthority()));
            logger.info("ROLES: " + role.getAuthority());
        }

        if (grantedAuthorityList == null) {
            logger.error("User no tiene roles");
            throw new UsernameNotFoundException("User no tiene roles");
        }


        return new User(
                user.getUsername(),
                user.getPassword(),
                user.getEnabled(),
                true,
                true,
                true,
                grantedAuthorityList
                );
    }
}
