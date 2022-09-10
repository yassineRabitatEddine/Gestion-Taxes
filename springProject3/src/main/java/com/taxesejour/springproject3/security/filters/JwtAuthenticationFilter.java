package com.taxesejour.springproject3.security.filters;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    /*Lorsque l'utilisateur voudra tenter de s'authentifier*/
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String username=request.getParameter("username");//Récupération d'username de la requête.
        String password=request.getParameter("password");//Récupération du mot de passe de la requête.
        UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(username,password);
        return authenticationManager.authenticate(authenticationToken);/*Appel à UserDetailsService afin de charger l'utilisateur via son username,
        puis vérfication du mot de passe s'il est valide, puis appel à la méthode successfulAuthentication() pour la génération du JWT.*/
    }

    /*Génération du JWT token si l'authentification a réussi*/
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException , ServletException{
        /*Création d'un utilisateur dont les infos sont générées à partir de l'objet authResult grâce à la méthode getPrinciple()*/
        User user=(User)authResult.getPrincipal();/*Cast vers le type User. L'objet user maintenant a le nom d'utilisateur, mot de passe et roles nécessaires
        pour la création du JWT.*/
        /*La méthode getPrincipal() n'est pas générique, elle retourne un résultat de type Obejct, donc un cast est nécessaire.*/

        Algorithm algorithm=Algorithm.HMAC256("MySecret1234560789");//Générer l'algo de signature.
        String jwtAccessToken= JWT.create().withSubject(user.getUsername()).withExpiresAt(new Date(System.currentTimeMillis()+15*60*1000))//La date d'expiration doit être en millisecondes.
                .withIssuer(request.getRequestURL().toString())//L'origine de la requête.
                .withClaim("roles",user.getAuthorities().stream().map(ga->ga.getAuthority()).collect(Collectors.toList()))
                .sign(algorithm);

        response.setHeader("Authorization",jwtAccessToken);//Envoi du token au client en créant un champ dans le header de la réponse qui s'appelle "Authorization".

        String jwtRefreshToken= JWT.create().withSubject(user.getUsername()).withExpiresAt(new Date(System.currentTimeMillis()+5*60*1000))//La date d'expiration doit être en millisecondes.
                .withIssuer(request.getRequestURL().toString())//L'origine de la requête.
                .sign(algorithm);
        Map<String,String> token=new HashMap<>();
        token.put("access-token",jwtAccessToken);
        token.put("refresh-token",jwtRefreshToken);
        response.setContentType("application/json");
        new ObjectMapper().writeValue(response.getOutputStream(),token);
   }
}
