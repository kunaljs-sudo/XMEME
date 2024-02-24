package com.crio.starter.httpexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
public class MethodNotAllowed extends RuntimeException { 
  public MethodNotAllowed(String msg) {
    super(msg);
  }
}
