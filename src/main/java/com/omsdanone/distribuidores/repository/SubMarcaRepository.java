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
import com.omsdanone.distribuidores.model.SubMarca;

@Repository
public class SubMarcaRepository {  // implements ISubMarca 
  @Autowired
  private JdbcTemplate jdbcTemplate;

  //@Override
  @SuppressWarnings("unchecked")
  public List<SubMarca> findById(Short submarcaid, Byte marcaid, int tiendaid) {
    try {
      SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
      .withProcedureName("usp_SelSubMarca")
      .returningResultSet("submarcas", 
        BeanPropertyRowMapper.newInstance(SubMarca.class));

      MapSqlParameterSource inParams = new MapSqlParameterSource()
      .addValue("p_SubMarcaID", submarcaid)
      .addValue("p_MarcaID", marcaid)
      .addValue("p_TiendaID", tiendaid);

      Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);
      
      return (List<SubMarca>) simpleJdbcCallResult.get("submarcas");
    } 
    catch (IncorrectResultSizeDataAccessException e) {
      return null;
    }
  }

  //@Override
  public RepositoryResult insert(SubMarca submarca, Short usuarioID) {
    String uspName = (submarca.getSubMarcaID() == 0 ? "usp_InsSubMarca" : "usp_UpdSubMarca");

    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName(uspName);

    MapSqlParameterSource inParams = new MapSqlParameterSource()
    .addValue("p_Nombre", submarca.getNombre())
    .addValue("p_MarcaID", submarca.getMarcaID())
    .addValue("p_UsuarioID", usuarioID);

    if (submarca.getSubMarcaID() > 0) {
      inParams.addValue("p_SubMarcaID", submarca.getSubMarcaID());
    }

    Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);

    submarca.setSubMarcaID ( ( (Number) simpleJdbcCallResult.get("out_Id") ).shortValue() ); 

    return new RepositoryResult(
      1, 
      "OK!", 
      (Integer) simpleJdbcCallResult.get("#update-count-1"), 
      submarca.getSubMarcaID().longValue() 
    );
  }

  //@Override
  public RepositoryResult deleteById(Short submarcaid, Short usuarioID) {
    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName("usp_DelSubMarca");

    MapSqlParameterSource inParams = new MapSqlParameterSource()
    .addValue("p_SubMarcaID", submarcaid)
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

