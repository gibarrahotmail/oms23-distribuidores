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
import com.omsdanone.distribuidores.model.CadenaComercial;

@Repository
public class CadenaComercialRepository {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  //@Override
  @SuppressWarnings("unchecked")
  public List<CadenaComercial> findById(Short cadenacomercialid) {
    try {
      SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
      .withProcedureName("usp_SelCadenaComercial")
      .returningResultSet("cadenacomercials", 
        BeanPropertyRowMapper.newInstance(CadenaComercial.class));

      MapSqlParameterSource inParams = new MapSqlParameterSource()
      .addValue("p_CadenaComercialId", cadenacomercialid);

      Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);
      
      return (List<CadenaComercial>) simpleJdbcCallResult.get("cadenacomercials");
    } 
    catch (IncorrectResultSizeDataAccessException e) {
      return null;
    }
  }

  //@Override
  public RepositoryResult insert(CadenaComercial cadenacomercial, Short usuarioID) {
    String uspName = (cadenacomercial.getCadenaComercialId() == 0 ? "usp_InsCadenaComercial" : "usp_UpdCadenaComercial");

    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName(uspName);

    MapSqlParameterSource inParams = new MapSqlParameterSource()
    .addValue("p_Codigo", cadenacomercial.getCodigo())
    .addValue("p_Nombre", cadenacomercial.getNombre())
    .addValue("p_Activa", cadenacomercial.getActiva())
    .addValue("p_UsuarioID", usuarioID);

    if (cadenacomercial.getCadenaComercialId() > 0) {
      inParams.addValue("p_CadenaComercialId", cadenacomercial.getCadenaComercialId());
    }

    Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);

    cadenacomercial.setCadenaComercialId ((Short) simpleJdbcCallResult.get("out_Id")); 

    return new RepositoryResult(
      1, 
      "OK!", 
      (Integer) simpleJdbcCallResult.get("#update-count-1"), 
      cadenacomercial.getCadenaComercialId().longValue() 
    );
  }

  //@Override
  public RepositoryResult deleteById(Short cadenacomercialid, Short usuarioID) {
    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName("usp_DelCadenaComercial");

    MapSqlParameterSource inParams = new MapSqlParameterSource().addValue("p_CadenaComercialId", cadenacomercialid)
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
