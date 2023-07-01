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

//import com.omsdanone.distribuidores.model.RepositoryResult;
import com.omsdanone.distribuidores.model.TipoUnidad;

@Repository
public class TipoUnidadRepository  {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  //@Override
  @SuppressWarnings("unchecked")
  public List<TipoUnidad> findById(Byte tipounidadid) {
    try {
      SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
      .withProcedureName("usp_SelTipoUnidad")
      .returningResultSet("tipounidads", 
        BeanPropertyRowMapper.newInstance(TipoUnidad.class));

      MapSqlParameterSource inParams = new MapSqlParameterSource()
      .addValue("p_TipoUnidadID", tipounidadid);

      Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);
      
      return (List<TipoUnidad>) simpleJdbcCallResult.get("tipounidads");
    } 
    catch (IncorrectResultSizeDataAccessException e) {
      return null;
    }
  }

  
}
