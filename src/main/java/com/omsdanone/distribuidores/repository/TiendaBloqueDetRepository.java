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
import com.omsdanone.distribuidores.model.TiendaBloqueDet;

@Repository
public class TiendaBloqueDetRepository {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  //@Override
  @SuppressWarnings("unchecked")
  public List<TiendaBloqueDet> findById(Integer tiendabloqueid) {
    try {
      SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
      .withProcedureName("usp_SelTiendaBloqueDet")
      .returningResultSet("tiendabloquedets", 
        BeanPropertyRowMapper.newInstance(TiendaBloqueDet.class));

      MapSqlParameterSource inParams = new MapSqlParameterSource()
      .addValue("p_TiendaBloqueId", tiendabloqueid);

      Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);
      
      return (List<TiendaBloqueDet>) simpleJdbcCallResult.get("tiendabloquedets");
    } 
    catch (IncorrectResultSizeDataAccessException e) {
      return null;
    }
  }

  //@Override
  public RepositoryResult insert(TiendaBloqueDet tiendabloquedet, Short usuarioID) {
    String uspName = "usp_InsTiendaBloqueDet";    //( == 0 ? "usp_InsTiendaBloqueDet" : "usp_UpdTiendaBloqueDet");

    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName(uspName);

    MapSqlParameterSource inParams = new MapSqlParameterSource()
    .addValue("p_TiendaBloqueId", tiendabloquedet.getTiendaBloqueId())
    .addValue("p_TiendaId", tiendabloquedet.getTiendaId())
    .addValue("p_Codigo", tiendabloquedet.getCodigo())
    //.addValue("p_RolDePedidoId_01", tiendabloquedet.getRolDePedidoId_01())
    //.addValue("p_UnidadId_01", tiendabloquedet.getUnidadId_01())
    //.addValue("p_RolDePedidoId_02", tiendabloquedet.getRolDePedidoId_02())
    //.addValue("p_UnidadId_02", tiendabloquedet.getUnidadId_02())
    .addValue("p_RolDePedidoId_1", tiendabloquedet.getRolDePedidoId_1())
    .addValue("p_UnidadId_1", tiendabloquedet.getUnidadId_1())
    .addValue("p_RolDePedidoId_2", tiendabloquedet.getRolDePedidoId_2())
    .addValue("p_UnidadId_2", tiendabloquedet.getUnidadId_2())
    .addValue("p_UsuarioID", usuarioID);

    /* if ( > 0) {
      inParams
    } */

    Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);

    //tiendabloquedet.set ((void) simpleJdbcCallResult.get("out_Id")); 

    return new RepositoryResult(
      1, 
      "OK!", 
      (Integer) simpleJdbcCallResult.get("#update-count-1"), 
      tiendabloquedet.getTiendaBloqueId().longValue() 
    );
  }

  /* /@Override
  public RepositoryResult deleteById(void , Short usuarioID) {
    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName("usp_DelTiendaBloqueDet");

    MapSqlParameterSource inParams = new MapSqlParameterSource()
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
  */

}
