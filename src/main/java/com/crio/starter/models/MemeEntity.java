package com.crio.starter.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "memes")
public class MemeEntity {
    
  @Id
  private String id;
  private String name;
  private String caption;
  private String url;

  public MemeEntity(String id, String name, String caption, String url) {
    this.id = id;
    this.name = name;
    this.caption = caption;
    this.url = url;
  }

  public MemeEntity() {
    
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCaption() {
    return caption;
  }

  public void setCaption(String caption) {
    this.caption = caption;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
    
    

    
}
