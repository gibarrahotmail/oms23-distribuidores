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
import com.omsdanone.distribuidores.model.Usuario;

@Repository
public class UsuarioRepository {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  //@Override
  @SuppressWarnings("unchecked")
  public List<Usuario> findById(Short usuarioid, Byte perfilid) {
    try {
      SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
      .withProcedureName("usp_SelUsuario")
      .returningResultSet("usuarios", 
        BeanPropertyRowMapper.newInstance(Usuario.class));

      MapSqlParameterSource inParams = new MapSqlParameterSource()
      .addValue("p_UsuarioID", usuarioid)
      .addValue("p_PerfilID", perfilid);

      Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);
      
      return (List<Usuario>) simpleJdbcCallResult.get("usuarios");
    } 
    catch (IncorrectResultSizeDataAccessException e) {
      return null;
    }
  }

  //@Override
  public RepositoryResult insert(Usuario usuario, Short usuarioID) {
    String uspName = (usuario.getUsuarioID() == 0 ? "usp_InsUsuario" : "usp_UpdUsuario");

    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName(uspName);

    MapSqlParameterSource inParams = new MapSqlParameterSource()
    .addValue("p_Apellidos", usuario.getApellidos())
    .addValue("p_Nombre", usuario.getNombre())
    .addValue("p_Cuenta", usuario.getCuenta())
    .addValue("p_Contrasenia", usuario.getContrasenia())
    .addValue("p_Activo", usuario.getActivo())
    .addValue("p_PerfilID", usuario.getPerfilID())
    .addValue("p_SectorID", usuario.getSectorID())
    .addValue("p_CadenaComercialId", usuario.getCadenaComercialId())
    .addValue("p_TiendaId", usuario.getTiendaId())
    .addValue("p_Permisos", usuario.getPermisos())
    .addValue("p_JefeID", usuario.getJefeID())
    .addValue("p_UsuarioID", usuarioID);

    if (usuario.getUsuarioID() > 0) {
      inParams.addValue("p_UsuarioID", usuario.getUsuarioID());
    }

    Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);

    usuario.setUsuarioID ((Short) simpleJdbcCallResult.get("out_Id")); 

    return new RepositoryResult(
      1, 
      "OK!", 
      (Integer) simpleJdbcCallResult.get("#update-count-1"), 
      usuario.getUsuarioID().longValue() 
    );
  }

  //@Override
  public RepositoryResult deleteById(Short usuarioid, Short usuarioID) {
    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName("usp_DelUsuario");

    MapSqlParameterSource inParams = new MapSqlParameterSource().addValue("p_UsuarioID", usuarioid)
    .addValue("p_UsuarioID", usuarioID);

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
