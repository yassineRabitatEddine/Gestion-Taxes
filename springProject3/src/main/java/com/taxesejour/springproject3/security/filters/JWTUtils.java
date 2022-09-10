package com.taxesejour.springproject3.security.filters;

public class JWTUtils {
    private final String SECRET_KEY="MySecretKey123456789";
    private final long ACCESS_TOKEN_EXPIRATION=5*60*1000;
    private final long REFRESH_TOKEN_EXPIRATION=15*60*1000;
}
