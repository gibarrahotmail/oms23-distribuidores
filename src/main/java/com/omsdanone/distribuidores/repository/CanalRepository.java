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
import com.omsdanone.distribuidores.model.Canal;

@Repository
public class CanalRepository {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  //@Override
  @SuppressWarnings("unchecked")
  public List<Canal> findById(byte canalid) {
    try {
      SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
      .withProcedureName("usp_SelCanal")
      .returningResultSet("canals", 
        BeanPropertyRowMapper.newInstance(Canal.class));

      MapSqlParameterSource inParams = new MapSqlParameterSource()
      .addValue("p_CanalId", canalid);

      Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);
      
      return (List<Canal>) simpleJdbcCallResult.get("canals");
    } 
    catch (IncorrectResultSizeDataAccessException e) {
      return null;
    }
  }

}
