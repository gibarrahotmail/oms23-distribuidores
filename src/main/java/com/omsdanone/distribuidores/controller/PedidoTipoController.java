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
import com.omsdanone.distribuidores.model.PedidoTipo;
import com.omsdanone.distribuidores.repository.PedidoTipoRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@Tag(name = "PedidoTipo", description = "PedidoTipo management endpoints")
@RestController
@RequestMapping("/api")
public class PedidoTipoController {

  @Autowired
  PedidoTipoRepository pedidotipoRepository;

  @GetMapping("/pedidotipo/{pedidotipoid}")
  public ResponseEntity<List<PedidoTipo>> getPedidoTipoById
  (@PathVariable("pedidotipoid") Byte pedidotipoid) {
    List<PedidoTipo> pedidotipos = pedidotipoRepository.findById(pedidotipoid);
   
    if (pedidotipos != null) {
      return new ResponseEntity<>(pedidotipos, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

}
