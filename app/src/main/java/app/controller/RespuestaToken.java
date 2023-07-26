package app.controller;

public class RespuestaToken {

  private String access_token;

  public RespuestaToken(String access_token) {
    super();
    this.access_token = access_token;
  }

  public RespuestaToken() {
    super();
    // TODO Auto-generated constructor stub
  }

  public String getAccess_token() {
    return access_token;
  }

  public void setAccess_token(String access_token) {
    this.access_token = access_token;
  }
}
