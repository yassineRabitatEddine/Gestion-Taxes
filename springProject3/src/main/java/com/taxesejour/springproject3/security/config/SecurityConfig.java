package com.taxesejour.springproject3.security.config;
import com.taxesejour.springproject3.security.entities.AppUser;
import com.taxesejour.springproject3.security.filters.JwtAuthenticationFilter;
import com.taxesejour.springproject3.security.filters.JwtAuthorizationFilter;
import com.taxesejour.springproject3.security.service.AppService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.ArrayList;
import java.util.Collection;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private AppService appService;

    public SecurityConfig(AppService appService) {
        this.appService = appService;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                AppUser appUser=appService.loadByUsername(username);
                /* Creation d'une collection de type GrantedAuthority vu que l'instance User n'accepte que les collections
                de type GrantedAuthority. Cette collection aura les roles de l'utilisateur chargé par la méthode loadByUsername*/
                Collection<GrantedAuthority> grantedAuthorities=new ArrayList<>();//Création d'une colection vide de type GrantedAuthority
                appUser.getAuthorities().forEach(r -> {//ForEach pour agir sur chaque role stocké dans la collection Roles de l'utilisateur.
                    grantedAuthorities.add(new SimpleGrantedAuthority(r.getAuthority()));
                });
                return new User(appUser.getUsername(),appUser.getPassword(),grantedAuthorities);
            }
        });

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/h2-console/**","/refreshToken/**","/login/**,/swagger-ui/**").permitAll();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        //http.formLogin();
        http.csrf().disable();
        http.headers().frameOptions().disable();
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/users/**").hasAuthority("ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/api/categorie/**").hasAuthority("ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/users/**").hasAuthority("USER");
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(new JwtAuthenticationFilter(authenticationManagerBean()));
        http.addFilterBefore(new JwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }
}
