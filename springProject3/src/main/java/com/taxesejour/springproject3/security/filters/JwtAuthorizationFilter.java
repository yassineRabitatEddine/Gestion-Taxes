package com.taxesejour.springproject3.security.filters;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class JwtAuthorizationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getServletPath().equals("/login")){
            filterChain.doFilter(request,response);
        }
        //A chaque requete qui arrive, on lit le Header Authorization du token.
        String authorizationToken=request.getHeader("Authorization");
        if (authorizationToken!=null && authorizationToken.startsWith("Bearer ")){
            /*Bearer est un préfixe utilisé pour spécifier qu'on s'est procédé à une authentification
            *par token et non pas une auth. Basic HTTP.*/
            try{
                String jwt=authorizationToken.substring(7);//Igoner le mot bearer pour ne récupérer que le jwt.
                Algorithm algorithm=Algorithm.HMAC256("MySecret1234560789");
                JWTVerifier jwtVerifier= JWT.require(algorithm).build();//Creation de l'objet qui va vérifier le token JWT.
                DecodedJWT decodedJWT=jwtVerifier.verify(jwt);
                //Recuperation des credentials pour authentifier l'utilisateur :
                String username=decodedJWT.getSubject();
                String[] roles=decodedJWT.getClaim("roles").asArray(String.class);//Specifier que les roles sont un tableau de String.
                Collection<GrantedAuthority> authorities=new ArrayList<>();
                for(String a:roles){
                    authorities.add(new SimpleGrantedAuthority(a));
                }
                UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(username,null,authorities);
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                filterChain.doFilter(request,response);

            }
            catch (Exception e){
                response.setHeader("error-message",e.getMessage());

            }
            filterChain.doFilter(request,response);
        }
    }
}
