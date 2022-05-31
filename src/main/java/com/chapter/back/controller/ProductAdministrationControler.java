package com.chapter.back.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.chapter.back.constant.RoutePath;
import com.chapter.back.constant.dto.ProductDTO;
import com.chapter.back.service.ProductService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(RoutePath.ROUTE_BASE_PATH_V1)
@Slf4j
public class ProductAdministrationControler {

  @Autowired
  private ProductService productService;

  // CRUD

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ProductDTO createProduct(@RequestBody @Valid ProductDTO product) {
    return productService.create(product);
 }
  
  
  

  @GetMapping(path = "/{id}")
  public ResponseEntity<ProductDTO> readProduct(@PathVariable Long id) {
    ProductDTO result = productService.findById(id);
    return ResponseEntity.ok().body(result);
  }

  @GetMapping(path = "/")
  public ResponseEntity<List<ProductDTO>> readAllProducts() {
    List<ProductDTO> result = productService.findAll();
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  
  
  
  @PutMapping(path = "/")
  public ResponseEntity<ProductDTO> updateReplaceProducts(@RequestParam Long id, @RequestBody ProductDTO product) {
    ProductDTO result = productService.update(id, product);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  @PatchMapping(path = "/{id}")
  public ResponseEntity<ProductDTO> updateModify(@PathVariable Long id, @RequestBody ProductDTO product) {
    ProductDTO result = productService.partialUpdate(id, product);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  
  
  
  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Void> deleteReplaceProducts(@PathVariable Long id) {
    log.info("Identificador a eliminar: " + id);
    productService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
