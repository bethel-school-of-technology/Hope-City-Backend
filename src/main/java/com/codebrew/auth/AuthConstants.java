package com.codebrew.auth;

public class AuthConstants {
    public static final String SECRET = "SuperSecretKey";
    public static final long EXPIRATION_TIME = 432_000_000;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/user";
    public static final String GET_ALL = "/user";
    public static final String GET_ONE = "/user/{email}";
    public static final String LOGIN = "/user/login";
    public static final String UPDATE = "/user/update/{id}";
}