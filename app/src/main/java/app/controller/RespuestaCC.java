package app.controller;

public class RespuestaCC {

  private boolean success;

  public RespuestaCC() {
    super();
    // TODO Auto-generated constructor stub
  }

  public RespuestaCC(boolean success) {
    super();
    this.success = success;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }
}
