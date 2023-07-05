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
import com.omsdanone.distribuidores.model.Tienda_Unidad;

@Repository
public class Tienda_UnidadRepository {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  //@Override
  @SuppressWarnings("unchecked")
  public List<Tienda_Unidad> findById(Integer tiendaid, Byte pedidotipoid) {
    try {
      SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
      .withProcedureName("usp_SelTienda_Unidad")
      .returningResultSet("tienda_unidads", 
        BeanPropertyRowMapper.newInstance(Tienda_Unidad.class));

      MapSqlParameterSource inParams = new MapSqlParameterSource()
      .addValue("p_TiendaId", tiendaid)
      .addValue("p_PedidoTipoId", pedidotipoid);

      Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);
      
      return (List<Tienda_Unidad>) simpleJdbcCallResult.get("tienda_unidads");
    } 
    catch (IncorrectResultSizeDataAccessException e) {
      return null;
    }
  }

  //@Override
  public RepositoryResult insert(Tienda_Unidad tienda_unidad, Short usuarioID) {
    String uspName = "usp_InsTienda_Unidad";  //(tienda_unidad.getPedidoTipoId() == 0 ? "usp_InsTienda_Unidad" : "usp_UpdTienda_Unidad");

    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName(uspName);

    MapSqlParameterSource inParams = new MapSqlParameterSource()
    .addValue("p_TiendaId", tienda_unidad.getTiendaId())
    .addValue("p_PedidoTipoId", tienda_unidad.getPedidoTipoId())
    .addValue("p_UnidadId", tienda_unidad.getUnidadId())
    .addValue("p_UsuarioID", usuarioID);

    //if ( > 0) {
    //  inParams
    //}

    Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);

    //tienda_unidad.set ((void) simpleJdbcCallResult.get("out_Id")); 

    return new RepositoryResult(
      1, 
      "OK!", 
      (Integer) simpleJdbcCallResult.get("#update-count-1"), 
      tienda_unidad.getTiendaId().longValue() 
    );
  }

  //@Override
  public RepositoryResult deleteById(Integer tiendaid, Byte pedidotipoid, Short usuarioID) {
    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName("usp_DelTienda_Unidad");

    MapSqlParameterSource inParams = new MapSqlParameterSource()
    .addValue("p_TiendaId", tiendaid)
    .addValue("p_PedidoTipoId", pedidotipoid)    
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
