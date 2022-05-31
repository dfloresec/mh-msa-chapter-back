package com.chapter.back.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.chapter.back.model.ProductEntity;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

  @Query(value = "SELECT new com.chapter.back.model.ProductEntity(p.name, p.price) FROM ProductEntity p")
  List<ProductEntity> findAllWithCodName();

}
