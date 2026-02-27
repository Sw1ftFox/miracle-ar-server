package com.miraclear.viewing.dto;

public class AuthDto {

  public static class Request {
    private String password;

    public String getPassword() {
      return password;
    }

    public void setPassword(String password) {
      this.password = password;
    }
  }

  public static class Response {
    private Boolean authenticated;

    public Boolean getAuthenticated() {
      return authenticated;
    }

    public void setAuthenticated(Boolean authenticated) {
      this.authenticated = authenticated;
    }
  }
}