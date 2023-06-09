package com.omsdanone.distribuidores.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.omsdanone.distribuidores.model.RepositoryResult;
import com.omsdanone.distribuidores.model.LogGlobal;
import com.omsdanone.distribuidores.repository.LogGlobalRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@Tag(name = "LogGlobal", description = "LogGlobal management endpoints")
@RestController
@RequestMapping("/api")
public class LogGlobalController {
   
  @Autowired
  LogGlobalRepository logglobalRepository;

  @GetMapping("/logglobal/{idlogglobal}/{usuarioid}")
  public ResponseEntity<List<LogGlobal>> getLogGlobalById
  (@PathVariable("idlogglobal") Long idlogglobal, @PathVariable("usuarioid") Short usuarioid,
    @RequestParam("desde") String desde, @RequestParam("hasta") String hasta) {
    List<LogGlobal> logglobals = logglobalRepository.findById(idlogglobal, usuarioid);
   
    if (logglobals != null) {
      return new ResponseEntity<>(logglobals, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }


  @PostMapping("/logglobal")
  public ResponseEntity<RepositoryResult> createLogGlobal (@RequestBody LogGlobal logglobal) {
    try {
      RepositoryResult rresult = logglobalRepository.insert(logglobal);
         
      return new ResponseEntity<>(rresult , HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println("Exception:");
      System.out.println(e);

      return new ResponseEntity<>(new RepositoryResult(500, e.getMessage(), 0, Long.valueOf("0")), 
        HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  /*
  @DeleteMapping("/logglobal/{idlogglobal}")
  public ResponseEntity<String> deletelogglobal(@PathVariable("idlogglobal") Long idlogglobal) {
    try {
      int result = logglobalRepository.deleteById(idlogglobal);

      if (result == 0) {
        return new ResponseEntity<>("Cannot find LogGlobal with id=" + idlogglobal, HttpStatus.OK);
      }
      return new ResponseEntity<>("LogGlobal was deleted successfully.", HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>("Cannot delete LogGlobal.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  */
}

