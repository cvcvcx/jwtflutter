package com.cvcvcx9.jwtflutter.config.security;

import com.cvcvcx9.jwtflutter.config.security.cors.CorsConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    private final CorsConfig corsConfig;

    @Bean
    public PasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails user = User.builder()
//                .username("user1")
//                .password(bCryptPasswordEncoder().encode("1111"))
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .authorizeRequests((auth->{
                    auth.antMatchers("/sample/all").permitAll();
                    auth.antMatchers("/sample/member").hasRole("USER");
                }))
                .formLogin().and()




//                .apply(new MyCustomDsl())
//                .and()
//                .authorizeRequests(authroize -> authroize.antMatchers("/api/v1/user/**")
//                                                         .access("hasRole('ROLE_USER') or hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
//                                                         .antMatchers("/api/v1/manager/**")
//                                                         .access("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
//                                                         .antMatchers("/api/v1/admin/**")
//                                                         .access("hasRole('ROLE_ADMIN')")
//                                                         .anyRequest()
//                                                         .permitAll())
                .build();


    }


//    public class MyCustomDsl extends AbstractHttpConfigurer<MyCustomDsl, HttpSecurity> {
//        @Override
//        public void configure(HttpSecurity http) throws Exception {
//            AuthenticationManager authenticationManager = http.getSharedObject(AuthenticationManager.class);
//            http.addFilter(corsConfig.corsFilter());
//
//        }
//    }
}
