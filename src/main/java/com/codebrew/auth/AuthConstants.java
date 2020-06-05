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
    public static final String UPDATE_Password = "/user/update/password/{id}";
    public static final String CREATE_EVENT = "/events/create";
    public static final String UPDATE_EVENT = "/events/update/{id}";
    public static final String DELETE_EVENT = "/events/delete/{id}";
    public static final String GET_ALL_EVENTS = "/events/getall";
    public static final String GET_ONE_EVENT = "/events/get/{id}";
    public static final String UPLOAD_IMAGE = "/image/upload";
    public static final String GET_IMAGE = "/image/get/{imageName}";
}