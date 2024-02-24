package com.crio.starter.exchange;

public class PostMemeResponse {
  private String id;

  public PostMemeResponse(String id) {
    this.id = id;
  }

  public PostMemeResponse() {
    
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

}
