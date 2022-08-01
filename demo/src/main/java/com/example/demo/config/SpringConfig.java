package com.example.demo.config;

import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final DataSource dataSource;

    public SpringConfig(DataSource dataSource){
        this.dataSource=dataSource;
    }

    @Bean
    public UserService userService(){
        return new UserService(userRepository());
    }
    @Bean
    public UserRepository userRepository(){
        return new UserRepository(dataSource);
    }


}
