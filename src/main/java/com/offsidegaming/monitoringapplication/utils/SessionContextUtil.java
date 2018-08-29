package com.offsidegaming.monitoringapplication.utils;

public class SessionContextUtil {

    private static final ThreadLocal<String> USER_SESSION = new ThreadLocal<>();

    public static void setUserSession(String userSession) {
        USER_SESSION.set(userSession);
    }

    public static String getUserSession() {
        return USER_SESSION.get();
    }
}