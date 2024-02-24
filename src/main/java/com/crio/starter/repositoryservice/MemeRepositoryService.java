package com.crio.starter.repositoryservice;

import com.crio.starter.models.MemeEntity;
import java.util.List;


public interface MemeRepositoryService {

  public MemeEntity getMemeById(String id);

  public List<MemeEntity> getLatestMemes();

  public MemeEntity createMeme(MemeEntity memeEntity);
    
}
