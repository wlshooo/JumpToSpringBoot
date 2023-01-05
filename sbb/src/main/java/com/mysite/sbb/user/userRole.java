package com.mysite.sbb.user;

import lombok.Getter;

public class userRole {

    @Getter
    public enum UserRole {
        ADMIN("ROLE_ADMIN"),
        USER("ROLE_USER");

        UserRole(String value) {
            this.value = value;
        }

        private String value;
    }
}
