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
import com.omsdanone.distribuidores.model.Transporte;


@Repository
public class TransporteRepository {  // implements ITransporte 
  @Autowired
  private JdbcTemplate jdbcTemplate;

  //@Override
  @SuppressWarnings("unchecked")
  public List<Transporte> findById(Short transporteid, Byte marcaid) {
    try {
      SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
      .withProcedureName("usp_SelTransporte")
      .returningResultSet("transportes", 
        BeanPropertyRowMapper.newInstance(Transporte.class));

      MapSqlParameterSource inParams = new MapSqlParameterSource()
      .addValue("p_TransporteID", transporteid)
      .addValue("p_MarcaID", marcaid);

      Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);
      
      return (List<Transporte>) simpleJdbcCallResult.get("transportes");
    } 
    catch (IncorrectResultSizeDataAccessException e) {
      return null;
    }
  }

  //@Override
  public RepositoryResult insert(Transporte transporte, Short usuarioID) {
    String uspName = (transporte.getTransporteID() == 0 ? "usp_InsTransporte" : "usp_UpdTransporte");

    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName(uspName);

    MapSqlParameterSource inParams = new MapSqlParameterSource()
    .addValue("p_Nombre", transporte.getNombre())
    .addValue("p_FT", transporte.getFT())
    .addValue("p_Capacidad", transporte.getCapacidad())
    .addValue("p_PesoTotalKgs", transporte.getPesoTotalKgs())
    .addValue("p_Entarimado", transporte.getEntarimado())
    .addValue("p_PerteneceALaPlanta", transporte.getPerteneceALaPlanta())
    .addValue("p_MarcaID", transporte.getMarcaID())
    .addValue("p_UsuarioID", usuarioID);

    if (transporte.getTransporteID() > 0) {
      inParams.addValue("p_TransporteID", transporte.getTransporteID());
    }

    Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);

    transporte.setTransporteID ( ( (Number) simpleJdbcCallResult.get("out_Id") ).shortValue() ); 

    return new RepositoryResult(
      1, 
      "OK!", 
      (Integer) simpleJdbcCallResult.get("#update-count-1"), 
      transporte.getTransporteID().longValue() 
    );
  }

  //@Override
  public RepositoryResult deleteById(Short transporteid, Short usuarioID) {
    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName("usp_DelTransporte");

    MapSqlParameterSource inParams = new MapSqlParameterSource()
    .addValue("p_TransporteID", transporteid)
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


