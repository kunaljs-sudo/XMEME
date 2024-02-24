package com.crio.starter.controller;


import com.crio.starter.dto.Meme;
import com.crio.starter.exception.NullValueException;
import com.crio.starter.exception.XMemeException;
import com.crio.starter.exchange.PostMemeRequest;
import com.crio.starter.exchange.PostMemeResponse;
import com.crio.starter.httpexception.ConflictException;
import com.crio.starter.httpexception.MethodNotAllowed;
import com.crio.starter.httpexception.NotFoundException;
import com.crio.starter.service.MemeService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(XMemeContoller.API_ENDPOINT)
public class XMemeContoller {
  //CHECKSTYLE:OFF

  @Autowired
  private MemeService memeService;

  public static final String API_ENDPOINT = "/memes";

  @GetMapping("")
  public ResponseEntity<List<Meme>> getLatestCollection() {
    List<Meme> getLatestMemes = memeService.getLatestCollection();
    return ResponseEntity.ok().body(getLatestMemes);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Meme> getMemeById(@PathVariable String id) {
    Meme meme;
    try { 
      meme = memeService.getMemeById(id);
    } catch (XMemeException e) {
      throw new NotFoundException("No such meme exist with id: " + id);
    }
    return ResponseEntity.ok().body(meme);
    
  }

  @PostMapping("")
  public ResponseEntity<PostMemeResponse> postMeme(
      @Valid @RequestBody PostMemeRequest postMemeRequest) {

    PostMemeResponse postMemeResponse;
    try {
      postMemeResponse = memeService.postNewMeme(postMemeRequest);
    } catch (XMemeException e) {
      throw new ConflictException(e.getMessage());
    } catch (NullValueException e) {
      throw new MethodNotAllowed(e.getMessage());
    }
    return ResponseEntity.ok().body(postMemeResponse);
  }



}
