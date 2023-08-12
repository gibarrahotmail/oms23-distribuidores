package com.omsdanone.distribuidores.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.omsdanone.distribuidores.model.RepositoryResult;
import com.omsdanone.distribuidores.model.Usuario_Tienda;

@Repository

public class Usuario_TiendaRepository {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  //@Override
  @SuppressWarnings("unchecked")
  public List<Usuario_Tienda> findById(Short usuarioid, Integer tiendaid, boolean tiendasSinUsuario, 
    boolean usuariosSinTienda) {
    try {
      SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
      .withProcedureName("usp_SelUsuario_Tienda")
      .returningResultSet("usuario_tiendas", 
        BeanPropertyRowMapper.newInstance(Usuario_Tienda.class));

      MapSqlParameterSource inParams = new MapSqlParameterSource()
      .addValue("p_UsuarioId", usuarioid)
      .addValue("p_TiendaId", tiendaid)
      .addValue("p_TiendasSinUsuario", tiendasSinUsuario)
      .addValue("p_UsuariosSinTienda", usuariosSinTienda);

      Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);
      
      return (List<Usuario_Tienda>) simpleJdbcCallResult.get("usuario_tiendas");
    } 
    catch (IncorrectResultSizeDataAccessException e) {
      return null;
    }
  }

  //@Override
  public RepositoryResult insert(Usuario_Tienda usuario_tienda, Short cadenaformatoid, Short usuarioIDupd) {
    String uspName = "usp_InsUsuario_Tienda"; // ( == 0 ? "usp_InsUsuario_Tienda" : "usp_UpdUsuario_Tienda");

    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName(uspName);

    MapSqlParameterSource inParams = new MapSqlParameterSource()
    .addValue("p_UsuarioId", usuario_tienda.getUsuarioId())
    .addValue("p_TiendaId", usuario_tienda.getTiendaId())
    .addValue("p_Codigo", usuario_tienda.getTienda())
    .addValue("p_CadenaFormatoId", cadenaformatoid)
    .addValue("p_UsuarioIDupd", usuarioIDupd);

    //if ( > 0) {
    //  inParams
    //}

    Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);

    //usuario_tienda.setUsuario( (void) simpleJdbcCallResult.get("out_Id")); 

    return new RepositoryResult(
      1, 
      "OK!", 
      (Integer) simpleJdbcCallResult.get("#update-count-1"), 
      usuario_tienda.getUsuarioId().longValue() 
    );
  }

  //@Override
  public RepositoryResult deleteById(Short usuarioid, Integer tiendaid, Short cadenaformatoid, Short usuarioIDupd,
  String codigo) {
    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName("usp_DelUsuario_Tienda");

    MapSqlParameterSource inParams = new MapSqlParameterSource()
    .addValue("p_UsuarioId", usuarioid)
    .addValue("p_TiendaId", tiendaid)
    .addValue("p_UsuarioIDupd", usuarioIDupd)
    .addValue("p_CadenaFormatoId", cadenaformatoid)
    .addValue("p_Codigo", codigo);

    Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);

    Long id = (Long) simpleJdbcCallResult.get("out_Id"); 

    return new RepositoryResult(
      1,
      "OK!",
      (Integer)simpleJdbcCallResult.get("#update-count-1"), 
      id
    );

  }

  
}
