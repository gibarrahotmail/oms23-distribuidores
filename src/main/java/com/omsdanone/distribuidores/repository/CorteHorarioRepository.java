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
import com.omsdanone.distribuidores.model.CorteHorario;

@Repository
public class CorteHorarioRepository {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  //@Override
  @SuppressWarnings("unchecked")
  public List<CorteHorario> findById(String corteHorarioId) {
    try {
      SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
      .withProcedureName("usp_SelCorteHorario")
      .returningResultSet("cortehorarios", 
        BeanPropertyRowMapper.newInstance(CorteHorario.class));

      MapSqlParameterSource inParams = new MapSqlParameterSource()
      .addValue("p_CorteHorarioId", corteHorarioId);

      Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);
      
      return (List<CorteHorario>) simpleJdbcCallResult.get("cortehorarios");
    } 
    catch (IncorrectResultSizeDataAccessException e) {
      return null;
    }
  }

  //@Override
  public RepositoryResult insert(CorteHorario cortehorario, Short usuarioID) {
    String uspName = "usp_InsCorteHorario"; //( == 0 ? "usp_InsCorteHorario" : "usp_UpdCorteHorario");

    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName(uspName);

    MapSqlParameterSource inParams = new MapSqlParameterSource()
    .addValue("p_CorteHorarioId", cortehorario.getCorteHorarioId())
    .addValue("p_Descripcion", cortehorario.getDescripcion())
    .addValue("p_UsuarioID", usuarioID);

    //if ( > 0) {
    //  inParams
    //} 

    Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);

    //cortehorario.set ((void) simpleJdbcCallResult.get("out_Id")); 

    return new RepositoryResult(
      1, 
      "OK!", 
      (Integer) simpleJdbcCallResult.get("#update-count-1"), 
      //cortehorario.get().longValue() 
      (long)1
    );
  }

  //@Override
  public RepositoryResult deleteById(String corteHorarioId, Short usuarioID) {
    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName("usp_DelCorteHorario");

    MapSqlParameterSource inParams = new MapSqlParameterSource()
    .addValue("p_CorteHorarioId", corteHorarioId)
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
