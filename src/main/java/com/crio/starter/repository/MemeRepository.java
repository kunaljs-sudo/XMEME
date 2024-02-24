package com.crio.starter.repository;

import com.crio.starter.models.MemeEntity;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface MemeRepository extends MongoRepository<MemeEntity, String> {
  boolean existsByNameAndCaptionAndUrl(String name, String caption, String url);

  public List<MemeEntity> findTop100ByOrderByIdDesc();
}
