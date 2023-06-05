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
import com.omsdanone.distribuidores.model.Marca;

@Repository
public class MarcaRepository {  // implements IMarca 
  @Autowired
  private JdbcTemplate jdbcTemplate;

  //@Override
  @SuppressWarnings("unchecked")
  public List<Marca> findById(Byte marcaid) {
    try {
      SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
      .withProcedureName("usp_SelMarca")
      .returningResultSet("marcas", 
        BeanPropertyRowMapper.newInstance(Marca.class));

      MapSqlParameterSource inParams = new MapSqlParameterSource()
      .addValue("p_MarcaID", marcaid);

      Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);
      
      return (List<Marca>) simpleJdbcCallResult.get("marcas");
    } 
    catch (IncorrectResultSizeDataAccessException e) {
      return null;
    }
  }

  //@Override
  public RepositoryResult insert(Marca marca, Short usuarioID) {
    String uspName = (marca.getMarcaID() == 0 ? "usp_InsMarca" : "usp_UpdMarca");

    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName(uspName);

    MapSqlParameterSource inParams = new MapSqlParameterSource()
    .addValue("p_Nombre", marca.getNombre())
    .addValue("p_UsuarioID", usuarioID);

    if (marca.getMarcaID() > 0) {
      inParams.addValue("p_MarcaID", marca.getMarcaID());
    }

    Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);

    marca.setMarcaID ( (byte)( (Number) simpleJdbcCallResult.get("out_Id") ).shortValue() ); 

    return new RepositoryResult(
      1, 
      "OK!", 
      (Integer) simpleJdbcCallResult.get("#update-count-1"), 
      marca.getMarcaID().longValue() 
    );
  }

  //@Override
  public RepositoryResult deleteById(Byte marcaid, Short usuarioID) {
    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName("usp_DelMarca");

    MapSqlParameterSource inParams = new MapSqlParameterSource()
    .addValue("p_MarcaID", marcaid)
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

