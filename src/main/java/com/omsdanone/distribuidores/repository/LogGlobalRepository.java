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
import com.omsdanone.distribuidores.model.LogGlobal;

@Repository
public class LogGlobalRepository  {  //implements ILogGlobal
  @Autowired
  private JdbcTemplate jdbcTemplate;

  //@Override
  @SuppressWarnings("unchecked")
  public List<LogGlobal> findById(Long idlogglobal, Short usuarioID) {
    try {
      SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
      .withProcedureName("usp_SelLogGlobal")
      .returningResultSet("logglobals", 
        BeanPropertyRowMapper.newInstance(LogGlobal.class));

      MapSqlParameterSource inParams = new MapSqlParameterSource()
      .addValue("p_IdLogGlobal", idlogglobal)
      .addValue("p_UsuarioID", usuarioID)
      .addValue("p_Desde", null)
      .addValue("p_Hasta", null);

      Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);
      
      return (List<LogGlobal>) simpleJdbcCallResult.get("logglobals");
    } 
    catch (IncorrectResultSizeDataAccessException e) {
      return null;
    }
  }

  //@Override
  public RepositoryResult insert(LogGlobal logglobal) {
    String uspName = (logglobal.getIdLogGlobal() == 0 ? "usp_InsLogGlobal" : "usp_UpdLogGlobal");

    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName(uspName);

    MapSqlParameterSource inParams = new MapSqlParameterSource()
    .addValue("p_UsuarioID", logglobal.getUsuarioID())
    .addValue("p_Registro", logglobal.getRegistro())
    .addValue("p_Operacion", logglobal.getOperacion())
    .addValue("p_Descrip", logglobal.getDescrip())
    .addValue("p_StatusFinal", logglobal.getStatusFinal());

    if (logglobal.getIdLogGlobal() > 0) {
      inParams.addValue("p_IdLogGlobal", logglobal.getIdLogGlobal());
    }
    /*
    System.out.println( "inParams" );
    System.out.println(inParams);

    MapSqlParameterSource inParams = new MapSqlParameterSource();

    if (logglobal.getIdLogGlobal() > 0) 
      inParams.addValue("p_IdLogGlobal", logglobal.getIdLogGlobal());

    inParams
    .addValue("p_UsuarioID", logglobal.getUsuarioID())
    .addValue("p_Registro", logglobal.getRegistro())
    .addValue("p_Operacion", logglobal.getOperacion())
    .addValue("p_Descrip", logglobal.getDescrip())
    .addValue("p_StatusFinal", logglobal.getStatusFinal());

    System.out.println( "inParams" );
    System.out.println(inParams);
    */

    Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);

    logglobal.setIdLogGlobal ((Long) simpleJdbcCallResult.get("out_Id")); 

    return new RepositoryResult(
      1, 
      "OK!", 
      (Integer) simpleJdbcCallResult.get("#update-count-1"), 
      logglobal.getIdLogGlobal().longValue() 
    );
  }

  /*
  //@Override
  public RepositoryResult deleteById(Long idlogglobal) {
    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName("usp_DelLogGlobal");

    MapSqlParameterSource inParams = new MapSqlParameterSource().addValue("p_IdLogGlobal", idlogglobal);

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
