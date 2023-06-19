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
import com.omsdanone.distribuidores.model.Compania;

@Repository
public class CompaniaRepository {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  //@Override
  @SuppressWarnings("unchecked")
  public List<Compania> findById(Byte companiaid) {
    try {
      SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
      .withProcedureName("usp_SelCompania")
      .returningResultSet("companias", 
        BeanPropertyRowMapper.newInstance(Compania.class));

      MapSqlParameterSource inParams = new MapSqlParameterSource()
      .addValue("p_CompaniaID", companiaid);

      Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);
      
      return (List<Compania>) simpleJdbcCallResult.get("companias");
    } 
    catch (IncorrectResultSizeDataAccessException e) {
      return null;
    }
  }

  /*
  //@Override
  public RepositoryResult insert(Compania compania, Short usuarioID) {
    String uspName = (compania.getCompaniaID() == 0 ? "usp_InsCompania" : "usp_UpdCompania");

    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName(uspName);

    MapSqlParameterSource inParams = new MapSqlParameterSource()
    .addValue("p_Nombre", compania.getNombre())
    .addValue("p_UsuarioID", usuarioID);

    if (compania.getCompaniaID() > 0) {
      inParams.addValue("p_CompaniaID", compania.getCompaniaID());
    }

    Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);

    compania.setCompaniaID ((Byte) simpleJdbcCallResult.get("out_Id")); 

    return new RepositoryResult(
      1, 
      "OK!", 
      (Integer) simpleJdbcCallResult.get("#update-count-1"), 
      compania.getCompaniaID().longValue() 
    );
  }

  //@Override
  public RepositoryResult deleteById(Byte companiaid, Short usuarioID) {
    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName("usp_DelCompania");

    MapSqlParameterSource inParams = new MapSqlParameterSource().addValue("p_CompaniaID", companiaid)
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
  */

}
