package com.crio.starter.exchange;

import com.crio.starter.dto.Meme;
import java.util.List;


public class GetLatestCollection {
  private List<Meme> latestMemes;


  public GetLatestCollection(List<Meme> latestMemes) {
    this.latestMemes = latestMemes;
  }

  public List<Meme> getLatestMemes() {
    return latestMemes;
  }

  public void setLatestMemes(List<Meme> latestMemes) {
    this.latestMemes = latestMemes;
  }


    
}
