package com.zosh.services.impl;




import com.zosh.domain.USER_ROLE;
import com.zosh.model.User;
import com.zosh.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class DataInitializationComponent implements CommandLineRunner {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;






    @Override
    public void run(String... args) {
        initializeAdminUser();
    }


    private void initializeAdminUser() {
        String adminUsername = "ss2727303@gmail.com";


        if (userRepository.findByEmail(adminUsername)==null) {
            User adminUser = new User();


            adminUser.setPassword(passwordEncoder.encode("sajidsai"));
            adminUser.setFullName("SAJID");
            adminUser.setEmail(adminUsername);
            adminUser.setRole(USER_ROLE.ROLE_ADMIN);


            User admin=userRepository.save(adminUser);
        }
    }


}


