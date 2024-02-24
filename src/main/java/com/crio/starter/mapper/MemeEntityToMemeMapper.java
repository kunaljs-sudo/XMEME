package com.crio.starter.mapper;

import com.crio.starter.dto.Meme;
import com.crio.starter.models.MemeEntity;
import java.util.List;



public interface MemeEntityToMemeMapper {
  public List<Meme> convertListMemeEntityToDto(List<MemeEntity> memeEntities);

  public Meme convertMemeEntityToDto(MemeEntity memeEntity);
}

