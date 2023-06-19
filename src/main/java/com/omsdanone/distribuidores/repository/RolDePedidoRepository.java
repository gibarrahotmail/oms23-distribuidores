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
import com.omsdanone.distribuidores.model.RolDePedido;

@Repository
public class RolDePedidoRepository {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  //@Override
  @SuppressWarnings("unchecked")
  public List<RolDePedido> findById(Short roldepedidoid) {
    try {
      SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
      .withProcedureName("usp_SelRolDePedido")
      .returningResultSet("roldepedidos", 
        BeanPropertyRowMapper.newInstance(RolDePedido.class));

      MapSqlParameterSource inParams = new MapSqlParameterSource()
      .addValue("p_RolDePedidoId", roldepedidoid);

      Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);
      
      return (List<RolDePedido>) simpleJdbcCallResult.get("roldepedidos");
    } 
    catch (IncorrectResultSizeDataAccessException e) {
      return null;
    }
  }

  //@Override
  public RepositoryResult insert(RolDePedido roldepedido, Short usuarioID) {
    String uspName = (roldepedido.getRolDePedidoId() == 0 ? "usp_InsRolDePedido" : "usp_UpdRolDePedido");

    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName(uspName);

    MapSqlParameterSource inParams = new MapSqlParameterSource()
    .addValue("p_Codigo", roldepedido.getCodigo())
    .addValue("p_Frecuencia", roldepedido.getFrecuencia())
    .addValue("p_TipoDeRol", roldepedido.getTipoDeRol())
    .addValue("p_HorasEntrega", roldepedido.getHorasEntrega())
    .addValue("p_Activo", roldepedido.getActivo())
    .addValue("p_UsuarioID", usuarioID);

    if (roldepedido.getRolDePedidoId() > 0) {
      inParams.addValue("p_RolDePedidoId", roldepedido.getRolDePedidoId());
    }

    Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);

    roldepedido.setRolDePedidoId ((Short) simpleJdbcCallResult.get("out_Id")); 

    return new RepositoryResult(
      1, 
      "OK!", 
      (Integer) simpleJdbcCallResult.get("#update-count-1"), 
      roldepedido.getRolDePedidoId().longValue() 
    );
  }

  //@Override
  public RepositoryResult deleteById(Short roldepedidoid, Short usuarioID) {
    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName("usp_DelRolDePedido");

    MapSqlParameterSource inParams = new MapSqlParameterSource().addValue("p_RolDePedidoId", roldepedidoid)
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
