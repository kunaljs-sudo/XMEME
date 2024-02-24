package com.crio.starter.repositoryservice;

import com.crio.starter.exception.XMemeException;
import com.crio.starter.models.MemeEntity;
import com.crio.starter.repository.MemeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class MemeRepositoryServiceImpl implements MemeRepositoryService {

  @Autowired
  private MemeRepository memeRepository;

  @Override
  public MemeEntity getMemeById(String id) {
    Optional<MemeEntity> optionalMemeEntity = memeRepository.findById(id);
    if (!optionalMemeEntity.isPresent()) {
      throw new XMemeException("No entry found for the id: " + id);
    }

    MemeEntity memeEntity = optionalMemeEntity.get();
    return memeEntity;
  }

  @Override
  public List<MemeEntity> getLatestMemes() {
    List<MemeEntity> allMemes = memeRepository.findTop100ByOrderByIdDesc();
    return allMemes;
  }

  @Override
  public MemeEntity createMeme(MemeEntity memeEntity) {
    if (memeRepository.existsByNameAndCaptionAndUrl(
        memeEntity.getName(),memeEntity.getCaption(), memeEntity.getUrl())) {
      throw new XMemeException("This meme is already present.");
    }
    return memeRepository.insert(memeEntity);
  }

}
