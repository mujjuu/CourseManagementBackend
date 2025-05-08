package com.courseenrrolmentsystem;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EnvDebug {
    @Value("${DB_URL}")
    private String dbUrl;

    @Value("${DB_USER}")
    private String dbUser;

    @Value("${DB_PASS}")
    private String dbPass;

    public void printEnvVars() {
        System.out.println("DB URL (Spring): " + dbUrl);
        System.out.println("DB User (Spring): " + dbUser);
        System.out.println("DB Pass (Spring): " + dbPass);
    }
}