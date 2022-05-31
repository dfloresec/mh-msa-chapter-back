package com.chapter.back.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chapter.back.constant.dto.ProductDTO;
import com.chapter.back.model.ProductEntity;
import com.chapter.back.repository.ProductRepository;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepositoryAutowired;

  public ProductDTO create(ProductDTO product) {
    return toProductDTO(productRepositoryAutowired.save(toProductEntity(product)));
  }

  public List<ProductDTO> findAll() {
    return toProductsDTO((List<ProductEntity>) productRepositoryAutowired.findAll());
  }

  public ProductDTO findById(Long id) {
    return toProductDTO(productRepositoryAutowired.findById(id).orElse(null));
  }

  public List<ProductDTO> findAllWithCodName() {
    return toProductsDTO(productRepositoryAutowired.findAllWithCodName());
  }

  public ProductDTO update(Long id, ProductDTO product) {
    Optional<ProductEntity> entity = productRepositoryAutowired.findById(id);
    ProductEntity entityUpdated = new ProductEntity();
    if (entity.isPresent()) {
      entityUpdated = entity.get();
    }
    entityUpdated.setName(product.getName());
    entityUpdated.setPrice(product.getPrice());
    entityUpdated.setStock(product.getStock());
    return toProductDTO(productRepositoryAutowired.save(entityUpdated));
  }

  public ProductDTO partialUpdate(Long id, ProductDTO product) {
    Optional<ProductEntity> entity = productRepositoryAutowired.findById(id);
    if (!entity.isPresent()) {
      return null;
    }
    ProductEntity entityUpdated = entity.get();
    if (product.getName() != null) {
      entityUpdated.setName(product.getName());
    }
    if (product.getPrice() != null) {
      entityUpdated.setPrice(product.getPrice());
    }
    if (product.getStock() != null) {
      entityUpdated.setStock(product.getStock());
    }
    return toProductDTO(productRepositoryAutowired.save(entityUpdated));
  }

  public void delete(Long id) {
    productRepositoryAutowired.deleteById(id);
  }

  private ProductDTO toProductDTO(ProductEntity p) {
    if (p == null) {
      return null;
    }
    return new ProductDTO(p.getId(), p.getName(), p.getPrice(), p.getStock());
  }

  private ProductEntity toProductEntity(ProductDTO p) {
    if (p == null) {
      return null;
    }
    return new ProductEntity(p.getName(), p.getPrice(), p.getStock());
  }

  private List<ProductDTO> toProductsDTO(List<ProductEntity> products) {
    return products.stream().map(p -> toProductDTO(p)).collect(Collectors.toList());
  }


}
