package org.lessons.java.project_final_auto_java.security;

import java.util.Optional;
import org.lessons.java.project_final_auto_java.model.User;
import org.lessons.java.project_final_auto_java.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DatabaseUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> userFind = userRepository.findByUsername(username);
        if (userFind.isEmpty()) {
            throw new UnsupportedOperationException("No username found with name:" + username);

        }
        return new DatabaseUserDetails(userFind.get());
    }

}
