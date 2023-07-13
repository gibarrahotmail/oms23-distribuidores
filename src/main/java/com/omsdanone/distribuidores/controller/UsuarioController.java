package com.omsdanone.distribuidores.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omsdanone.distribuidores.model.RepositoryResult;
import com.omsdanone.distribuidores.model.Usuario;
import com.omsdanone.distribuidores.repository.UsuarioRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@Tag(name = "Usuario", description = "Usuario management endpoints")
@RestController
@RequestMapping("/api")
public class UsuarioController {
  @Autowired
  UsuarioRepository usuarioRepository;

  @GetMapping("/usuario/{usuarioid}/{perfilid}/{companiaid}")
  public ResponseEntity<List<Usuario>> getUsuarioById
  (@PathVariable("usuarioid") Short usuarioid, @PathVariable("perfilid") Byte perfilid, @PathVariable("companiaid") Byte companiaid) {
    List<Usuario> usuarios = usuarioRepository.findById(usuarioid, perfilid, companiaid);
   
    if (usuarios != null) {
      return new ResponseEntity<>(usuarios, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }


  @PostMapping("/usuario/{usuarioid}")
  public ResponseEntity<RepositoryResult> createUsuario (@RequestBody Usuario usuario, 
    @PathVariable("usuarioid") Short usuarioid) {
    try {
      RepositoryResult rresult = usuarioRepository.insert(usuario, usuarioid);
         
      return new ResponseEntity<>(rresult , HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);

      return new ResponseEntity<>(new RepositoryResult(500, e.getMessage(), 0, Long.valueOf("0")), 
        HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


  @DeleteMapping("/usuario/{usuarioid}/{usuarioidupd}")
  public ResponseEntity<RepositoryResult> deleteusuario(@PathVariable("usuarioid") Short usuarioid, 
  @PathVariable("usuarioidupd") Short usuarioidupd) {
    try {
      RepositoryResult rresult = usuarioRepository.deleteById(usuarioid, usuarioidupd);

      return new ResponseEntity<>(rresult , HttpStatus.CREATED);
    } catch (Exception e) {
      System.out.println(e);
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  } 
}
