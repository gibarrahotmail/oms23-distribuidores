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
import com.omsdanone.distribuidores.model.CadenaFormato;

@Repository
public class CadenaFormatoRepository {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  //@Override
  @SuppressWarnings("unchecked")
  public List<CadenaFormato> findById(Short cadenaformatoid, Short cadenacomercialid) {
    try {
      SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
      .withProcedureName("usp_SelCadenaFormato")
      .returningResultSet("cadenaformatos", 
        BeanPropertyRowMapper.newInstance(CadenaFormato.class));

      MapSqlParameterSource inParams = new MapSqlParameterSource()
      .addValue("p_CadenaFormatoId", cadenaformatoid)
      .addValue("p_CadenaComercialId", cadenacomercialid);

      Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);
      
      return (List<CadenaFormato>) simpleJdbcCallResult.get("cadenaformatos");
    } 
    catch (IncorrectResultSizeDataAccessException e) {
      return null;
    }
  }

  //@Override
  public RepositoryResult insert(CadenaFormato cadenaformato, Short usuarioID) {
    String uspName = (cadenaformato.getCadenaFormatoId() == 0 ? "usp_InsCadenaFormato" : "usp_UpdCadenaFormato");

    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName(uspName);

    MapSqlParameterSource inParams = new MapSqlParameterSource()
    .addValue("p_Codigo", cadenaformato.getCodigo())
    .addValue("p_Nombre", cadenaformato.getNombre())
    .addValue("p_Activa", cadenaformato.getActiva())
    .addValue("p_CadenaComercialId", cadenaformato.getCadenaComercialId())
    .addValue("p_CanalId", cadenaformato.getCanalId())
    .addValue("p_UsuarioID", usuarioID);

    if (cadenaformato.getCadenaFormatoId() > 0) {
      inParams.addValue("p_CadenaFormatoId", cadenaformato.getCadenaFormatoId());
    }

    Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);

    cadenaformato.setCadenaFormatoId( ( (Number) simpleJdbcCallResult.get("out_Id") ).shortValue() ); 

    return new RepositoryResult(
      1, 
      "OK!", 
      (Integer) simpleJdbcCallResult.get("#update-count-1"), 
      cadenaformato.getCadenaFormatoId().longValue() 
    );
  }

  //@Override
  public RepositoryResult deleteById(Short cadenaformatoid, Short usuarioID) {
    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName("usp_DelCadenaFormato");

    MapSqlParameterSource inParams = new MapSqlParameterSource().addValue("p_CadenaFormatoId", cadenaformatoid)
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
