package app.controller;

public class RespuestaMM {

  private int totalHits;

  public RespuestaMM() {
    super();
    // TODO Auto-generated constructor stub
  }

  public RespuestaMM(int totalHits) {
    super();
    this.totalHits = totalHits;
  }

  public int getTotalHits() {
    return totalHits;
  }

  public void setTotalHits(int totalHits) {
    this.totalHits = totalHits;
  }
}
