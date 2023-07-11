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
import com.omsdanone.distribuidores.model.PedidoStatus;

@Repository
public class PedidoStatusRepository {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  //@Override
  @SuppressWarnings("unchecked")
  public List<PedidoStatus> findById(Byte pedidostatusid) {
    try {
      SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
      .withProcedureName("usp_SelPedidoStatus")
      .returningResultSet("pedidostatuss", 
        BeanPropertyRowMapper.newInstance(PedidoStatus.class));

      MapSqlParameterSource inParams = new MapSqlParameterSource()
      .addValue("p_PedidoStatusID", pedidostatusid);

      Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);
      
      return (List<PedidoStatus>) simpleJdbcCallResult.get("pedidostatuss");
    } 
    catch (IncorrectResultSizeDataAccessException e) {
      return null;
    }
  }

}
