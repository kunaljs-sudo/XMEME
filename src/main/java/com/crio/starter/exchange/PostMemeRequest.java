package com.crio.starter.exchange;

import org.springframework.lang.NonNull;

public class PostMemeRequest {

  @NonNull
  private String name;

  @NonNull
  private String url;

  @NonNull
  private String caption;


  public PostMemeRequest(String name, String url, String caption) {
    this.name = name;
    this.caption = caption;
    this.url = url;
  }

  public PostMemeRequest() {
    
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getCaption() {
    return caption;
  }

  public void setCaption(String caption) {
    this.caption = caption;
  }

  @Override
  public String toString() {
    return "PostMemeRequest [caption=" + caption + ", name=" + name + ", url=" + url + "]";
  }

  


}
