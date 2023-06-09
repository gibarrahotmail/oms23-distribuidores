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
import com.omsdanone.distribuidores.model.Tienda;

@Repository
public class TiendaRepository {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  //@Override
  @SuppressWarnings("unchecked")
  public List<Tienda> findById(Integer tiendaid, Short cadenacomercialid, Short cadenaformatoid) {
    try {
      SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
      .withProcedureName("usp_SelTienda")
      .returningResultSet("tiendas", 
        BeanPropertyRowMapper.newInstance(Tienda.class));

      MapSqlParameterSource inParams = new MapSqlParameterSource()
      .addValue("p_TiendaId", tiendaid)
      .addValue("p_CadenaComercialId", cadenacomercialid)
      .addValue("p_CadenaFormatoId", cadenaformatoid);

      Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);
      
      return (List<Tienda>) simpleJdbcCallResult.get("tiendas");
    } 
    catch (IncorrectResultSizeDataAccessException e) {
      return null;
    }
  }

  //@Override
  public RepositoryResult insert(Tienda tienda, Short usuarioID) {
    String uspName = (tienda.getTiendaId() == 0 ? "usp_InsTienda" : "usp_UpdTienda");

    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName(uspName);

    MapSqlParameterSource inParams = new MapSqlParameterSource()
    .addValue("p_Codigo", tienda.getCodigo())
    .addValue("p_Nombre", tienda.getNombre())
    .addValue("p_Calle", tienda.getCalle())
    .addValue("p_Colonia", tienda.getColonia())
    .addValue("p_Delegacion", tienda.getDelegacion())
    .addValue("p_CP", tienda.getCP())
    .addValue("p_EntidadFederativaId", tienda.getEntidadFederativaId())
    .addValue("p_Ciudad", tienda.getCiudad())
    .addValue("p_Activa", tienda.getActiva())
    .addValue("p_CadenaComercialId", tienda.getCadenaComercialId())
    .addValue("p_RegionID", tienda.getRegionID())
    .addValue("p_SectorID", tienda.getSectorID())
    .addValue("p_CorteHorarioId", tienda.getCorteHorarioId())
    .addValue("p_CadenaFormatoId", tienda.getCadenaFormatoId())
    .addValue("p_RolDePedidoId1", tienda.getRolDePedidoId1())
    .addValue("p_RolDePedidoId2", tienda.getRolDePedidoId2())
    .addValue("p_UnidadId1", tienda.getUnidadId1())
    .addValue("p_UnidadId2", tienda.getUnidadId2())
    .addValue("p_UsuarioID", usuarioID);

    if (tienda.getTiendaId() > 0) {
      inParams.addValue("p_TiendaId", tienda.getTiendaId());
    }

    Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);

    tienda.setTiendaId ( ( (Number) simpleJdbcCallResult.get("out_Id") ).intValue() ); 

    return new RepositoryResult(
      1, 
      "OK!", 
      (Integer) simpleJdbcCallResult.get("#update-count-1"), 
      tienda.getTiendaId().longValue() 
    );
  }

  //@Override
  public RepositoryResult deleteById(Integer tiendaid, Short usuarioID) {
    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName("usp_DelTienda");

    MapSqlParameterSource inParams = new MapSqlParameterSource()
    .addValue("p_TiendaId", tiendaid)
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
