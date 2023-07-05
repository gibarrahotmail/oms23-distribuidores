package com.omsdanone.distribuidores.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.omsdanone.distribuidores.model.RepositoryResult;
import com.omsdanone.distribuidores.model.Canal;
import com.omsdanone.distribuidores.repository.CanalRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@Tag(name = "Canal", description = "Canal management endpoints")
@RestController
@RequestMapping("/api")

public class CanalController {
  @Autowired
  CanalRepository canalRepository;

  @GetMapping("/canal/{canalid}")
  public ResponseEntity<List<Canal>> getCanalById
  (@PathVariable("canalid") Byte canalid) {
    List<Canal> canals = canalRepository.findById(canalid);
   
    if (canals != null) {
      return new ResponseEntity<>(canals, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

}
