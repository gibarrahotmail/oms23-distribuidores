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
import com.omsdanone.distribuidores.model.Presentacion;

@Repository
public class PresentacionRepository {  // implements IPresentacion
  @Autowired
  private JdbcTemplate jdbcTemplate;

  //@Override
  @SuppressWarnings("unchecked")
  public List<Presentacion> findById(Short presentacionid, Byte marcaid) {
    try {
      SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
      .withProcedureName("usp_SelPresentacion")
      .returningResultSet("presentacions", 
        BeanPropertyRowMapper.newInstance(Presentacion.class));

      MapSqlParameterSource inParams = new MapSqlParameterSource()
      .addValue("p_PresentacionID", presentacionid)
      .addValue("p_MarcaID", marcaid);

      Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);
      
      return (List<Presentacion>) simpleJdbcCallResult.get("presentacions");
    } 
    catch (IncorrectResultSizeDataAccessException e) {
      return null;
    }
  }


  //@Override
  public RepositoryResult insert(Presentacion presentacion, Short usuarioID) {
    String uspName = (presentacion.getPresentacionID() == 0 ? "usp_InsPresentacion" : "usp_UpdPresentacion");

    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName(uspName);

    MapSqlParameterSource inParams = new MapSqlParameterSource()
    .addValue("p_Nombre", presentacion.getNombre())
    .addValue("p_MarcaID", presentacion.getMarcaID())
    .addValue("p_UsuarioID", usuarioID);

    if (presentacion.getPresentacionID() > 0) 
      inParams.addValue("p_PresentacionID", presentacion.getPresentacionID());

    Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);

    presentacion.setPresentacionID ( ( (Number) simpleJdbcCallResult.get("out_Id") ).shortValue() ); 

    return new RepositoryResult(
      1, 
      "OK!", 
      (Integer) simpleJdbcCallResult.get("#update-count-1"), 
      presentacion.getPresentacionID().longValue() 
    );
  }

  //@Override
  public RepositoryResult deleteById(Short presentacionid, Short usuarioID) {
    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName("usp_DelPresentacion");

    MapSqlParameterSource inParams = new MapSqlParameterSource()
    .addValue("p_PresentacionID", presentacionid)
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

