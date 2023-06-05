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
import com.omsdanone.distribuidores.model.Distribuidor;

@Repository
public class DistribuidorRepository {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  @SuppressWarnings("unchecked")
  public List<Distribuidor> findById(Short distribuidorid) {
    try {
      SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
      .withProcedureName("usp_SelDistribuidor")
      .returningResultSet("distribuidors", 
        BeanPropertyRowMapper.newInstance(Distribuidor.class));

      MapSqlParameterSource inParams = new MapSqlParameterSource()
      .addValue("p_DistribuidorID", distribuidorid);

      Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);
      
      return (List<Distribuidor>) simpleJdbcCallResult.get("distribuidors");
    } 
    catch (IncorrectResultSizeDataAccessException e) {
      return null;
    }
  }

  public RepositoryResult insert(Distribuidor distribuidor, Short usuarioID) {
    String uspName = (distribuidor.getDistribuidorID() == 0 ? "usp_InsDistribuidor" : "usp_UpdDistribuidor");

    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName(uspName);

    MapSqlParameterSource inParams = new MapSqlParameterSource()
    .addValue("p_RegionID", distribuidor.getRegionID())
    .addValue("p_NumeroCliente", distribuidor.getNumeroCliente())
    .addValue("p_Contacto", distribuidor.getContacto())
    .addValue("p_Nombre", distribuidor.getNombre())
    .addValue("p_Direccion", distribuidor.getDireccion())
    .addValue("p_CiudadID", distribuidor.getCiudadID())
    .addValue("p_CeDisID", distribuidor.getCeDisID())
    .addValue("p_Credito", distribuidor.getCredito())
    .addValue("p_Activo", distribuidor.getActivo())
    .addValue("p_TransportesPropios", distribuidor.getTransportesPropios())
    .addValue("p_HorasEntrega", distribuidor.getHorasEntrega())
    .addValue("p_email", distribuidor.getEmail())
    .addValue("p_emailCC1", distribuidor.getEmailCC1())
    .addValue("p_emailCC2", distribuidor.getEmailCC2())
    .addValue("p_PedidosXSemana", distribuidor.getPedidosXSemana())
    .addValue("p_pcExtraXPedido", distribuidor.getPcExtraXPedido())
    .addValue("p_SalesGroupId", distribuidor.getSalesGroupId())
    .addValue("p_UsuarioID", usuarioID);

    if (distribuidor.getDistribuidorID() > 0) {
      inParams.addValue("p_DistribuidorID", distribuidor.getDistribuidorID());
    }

    Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);

    distribuidor.setDistribuidorID ( ( (Number) simpleJdbcCallResult.get("out_Id") ).shortValue() );

    return new RepositoryResult(
      1, 
      "OK!", 
      (Integer) simpleJdbcCallResult.get("#update-count-1"), 
      distribuidor.getDistribuidorID().longValue() 
    );
  }

  public RepositoryResult deleteById(Short distribuidorid, Short usuarioID) {
    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName("usp_DelDistribuidor");

    MapSqlParameterSource inParams = new MapSqlParameterSource()
    .addValue("p_DistribuidorID", distribuidorid)
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

