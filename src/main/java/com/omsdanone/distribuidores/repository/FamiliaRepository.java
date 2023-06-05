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
import com.omsdanone.distribuidores.model.Familia;

@Repository
public class FamiliaRepository {  // implements IFamilia 
  @Autowired
  private JdbcTemplate jdbcTemplate;

  //@Override
  @SuppressWarnings("unchecked")
  public List<Familia> findById(Byte familiaid, Byte marcaid) {
    try {
      SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
      .withProcedureName("usp_SelFamilia")
      .returningResultSet("familias", 
        BeanPropertyRowMapper.newInstance(Familia.class));

      MapSqlParameterSource inParams = new MapSqlParameterSource()
      .addValue("p_FamiliaID", familiaid)
      .addValue("p_MarcaID", marcaid);

      Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);
      
      return (List<Familia>) simpleJdbcCallResult.get("familias");
    } 
    catch (IncorrectResultSizeDataAccessException e) {
      return null;
    }
  }

  //@Override
  public RepositoryResult insert(Familia familia, Short usuarioID) {
    String uspName = (familia.getFamiliaID() == 0 ? "usp_InsFamilia" : "usp_UpdFamilia");

    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName(uspName);

    MapSqlParameterSource inParams = new MapSqlParameterSource()
    .addValue("p_Nombre", familia.getNombre())
    .addValue("p_MarcaID", familia.getMarcaID())
    .addValue("p_UsuarioID", usuarioID);

    if (familia.getFamiliaID() > 0) {
      inParams.addValue("p_FamiliaID", familia.getFamiliaID());
    }

    Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);

    familia.setFamiliaID ( (byte)((Number) simpleJdbcCallResult.get("out_Id")).shortValue() ); 

    return new RepositoryResult(
      1, 
      "OK!", 
      (Integer) simpleJdbcCallResult.get("#update-count-1"), 
      familia.getFamiliaID().longValue() 
    );
  }

  //@Override
  public RepositoryResult deleteById(Byte familiaid, Short usuarioID) {
    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName("usp_DelFamilia");

    MapSqlParameterSource inParams = new MapSqlParameterSource()
    .addValue("p_FamiliaID", familiaid)
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

