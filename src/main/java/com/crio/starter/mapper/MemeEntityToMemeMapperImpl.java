package com.crio.starter.mapper;

import com.crio.starter.dto.Meme;
import com.crio.starter.models.MemeEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;


@Service
public class MemeEntityToMemeMapperImpl implements MemeEntityToMemeMapper {

  @Override
  public List<Meme> convertListMemeEntityToDto(@NonNull List<MemeEntity> memeEntities) {
    List<Meme> allMemes = new ArrayList<>();

    for (MemeEntity memeEntity : memeEntities) {
      Meme meme = new Meme();
      meme.setId(memeEntity.getId());
      meme.setName(memeEntity.getName());
      meme.setCaption(memeEntity.getCaption());
      meme.setUrl(memeEntity.getUrl());

      allMemes.add(meme);
    }
    return allMemes;
  }

  @Override
  public Meme convertMemeEntityToDto(@NonNull MemeEntity memeEntity) {
    Meme meme = new Meme();
    meme.setId(memeEntity.getId());
    meme.setName(memeEntity.getName());
    meme.setCaption(memeEntity.getCaption());
    meme.setUrl(memeEntity.getUrl());
    return meme;
  }

}
