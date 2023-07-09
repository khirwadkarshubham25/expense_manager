package org.expenseManager.dto;

public class LoginResponseDto {
    private String accessToken;
    private String message;

    public LoginResponseDto(String accessToken, String message) {
        this.accessToken = accessToken;
        this.message = message;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getMessage() {
        return message;
    }
}
