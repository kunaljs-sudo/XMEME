package com.crio.starter.service;

import com.crio.starter.dto.Meme;
import com.crio.starter.exception.NullValueException;
import com.crio.starter.exchange.PostMemeRequest;
import com.crio.starter.exchange.PostMemeResponse;
import com.crio.starter.mapper.MemeEntityToMemeMapper;
import com.crio.starter.models.MemeEntity;
import com.crio.starter.repositoryservice.MemeRepositoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemeServiceImpl implements MemeService {

  @Autowired
  private MemeRepositoryService memeRepositoryService;

  @Autowired
  private MemeEntityToMemeMapper memeMapper;


  @Override
  public PostMemeResponse postNewMeme(PostMemeRequest postMemeRequest) {
    if (postMemeRequest.getName() == null || postMemeRequest.getCaption() == null 
        || postMemeRequest.getUrl() == null) {
      throw new NullValueException("Null value present. Please add some values");
    }
    MemeEntity memeEntity = new MemeEntity();
    memeEntity.setName(postMemeRequest.getName());
    memeEntity.setCaption(postMemeRequest.getCaption());
    memeEntity.setUrl(postMemeRequest.getUrl());

    MemeEntity memeEntityResponse = memeRepositoryService.createMeme(memeEntity);

    PostMemeResponse postMemeResponse = new PostMemeResponse();
    postMemeResponse.setId(memeEntityResponse.getId());

    return postMemeResponse;
  }

  @Override
  public List<Meme> getLatestCollection() {
    List<MemeEntity> allMemeEntities = memeRepositoryService.getLatestMemes();
    List<Meme> latestMemes = memeMapper.convertListMemeEntityToDto(allMemeEntities);

    return latestMemes;
  }

  @Override
  public Meme getMemeById(String id) {
    MemeEntity memeEntity = memeRepositoryService.getMemeById(id);
    return memeMapper.convertMemeEntityToDto(memeEntity);
  }

}
