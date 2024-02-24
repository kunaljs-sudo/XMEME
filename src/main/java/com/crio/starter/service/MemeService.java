package com.crio.starter.service;

import com.crio.starter.dto.Meme;
import com.crio.starter.exchange.PostMemeRequest;
import com.crio.starter.exchange.PostMemeResponse;
import java.util.List;

public interface MemeService {

  public PostMemeResponse postNewMeme(PostMemeRequest postMemeRequest);

  public List<Meme> getLatestCollection();

  public Meme getMemeById(String id);
}
