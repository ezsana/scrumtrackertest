package com.codecool.zsana.scrumtrackertest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Basetest {

    private String username = "zsana6";
    private String password = "zsana6";
    private String email = "zsana6@zsana6.com";

    private String username2 = "zsana";
    private String password2 = "zsana";
    private String email2 = "zsana@zsana.com";

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername2() {
        return username2;
    }

    public String getPassword2() {
        return password2;
    }

    public String getEmail() {
        return email;
    }

    public String getEmail2() {
        return email2;
    }

    public String generateDate() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM.dd");
        return dateTime.format(formatter);
    }
}
