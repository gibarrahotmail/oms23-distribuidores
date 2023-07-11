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
import com.omsdanone.distribuidores.model.PedidoStatus;
import com.omsdanone.distribuidores.repository.PedidoStatusRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@Tag(name = "PedidoStatus", description = "PedidoStatus management endpoints")
@RestController
@RequestMapping("/api")
public class PedidoStatusController {
  @Autowired
  PedidoStatusRepository pedidostatusRepository;

  @GetMapping("/pedidostatus/{pedidostatusid}")
  public ResponseEntity<List<PedidoStatus>> getPedidoStatusById
  (@PathVariable("pedidostatusid") Byte pedidostatusid) {
    List<PedidoStatus> pedidostatuss = pedidostatusRepository.findById(pedidostatusid);
   
    if (pedidostatuss != null) {
      return new ResponseEntity<>(pedidostatuss, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

}
