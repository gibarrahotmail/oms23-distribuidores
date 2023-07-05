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
import com.omsdanone.distribuidores.model.Tienda_RolDePedido;

@Repository
public class Tienda_RolDePedidoRepository {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  //@Override
  @SuppressWarnings("unchecked")
  public List<Tienda_RolDePedido> findById(Integer tiendaid, Byte pedidotipoid) {
    try {
      SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
      .withProcedureName("usp_SelTienda_RolDePedido")
      .returningResultSet("tienda_roldepedidos", 
        BeanPropertyRowMapper.newInstance(Tienda_RolDePedido.class));

      MapSqlParameterSource inParams = new MapSqlParameterSource()
      .addValue("p_TiendaId", tiendaid)
      .addValue("p_PedidoTipoId", pedidotipoid);

      Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);
      
      return (List<Tienda_RolDePedido>) simpleJdbcCallResult.get("tienda_roldepedidos");
    } 
    catch (IncorrectResultSizeDataAccessException e) {
      return null;
    }
  }

  //@Override
  public RepositoryResult insert(Tienda_RolDePedido tienda_roldepedido, Short usuarioID) {
    String uspName = "usp_InsTienda_RolDePedido"; //( == 0 ? "usp_InsTienda_RolDePedido" : "usp_UpdTienda_RolDePedido");

    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName(uspName);

    MapSqlParameterSource inParams = new MapSqlParameterSource()
    .addValue("p_TiendaId", tienda_roldepedido.getTiendaId())
    .addValue("p_PedidoTipoId", tienda_roldepedido.getPedidoTipoId())
    .addValue("p_RolDePedidoId", tienda_roldepedido.getRolDePedidoId())
    .addValue("p_FechaActivacion", tienda_roldepedido.getFechaActivacion())
    .addValue("p_FechaDesactivacion", tienda_roldepedido.getFechaDesactivacion())
    .addValue("p_UsuarioID", usuarioID);

    //if ( > 0) {
    //  inParams
    //}

    Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);

    //tienda_roldepedido.set ((void) simpleJdbcCallResult.get("out_Id")); 

    return new RepositoryResult(
      1, 
      "OK!", 
      (Integer) simpleJdbcCallResult.get("#update-count-1"), 
      tienda_roldepedido.getTiendaId().longValue() 
    );
  }

  //@Override
  public RepositoryResult deleteById(Integer tiendaid, Byte pedidotipoid, Short usuarioID) {
    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName("usp_DelTienda_RolDePedido");

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
