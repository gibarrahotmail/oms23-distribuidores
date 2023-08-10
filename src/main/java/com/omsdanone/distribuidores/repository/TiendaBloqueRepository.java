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
import com.omsdanone.distribuidores.model.TiendaBloque;

@Repository
public class TiendaBloqueRepository {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  //@Override
  @SuppressWarnings("unchecked")
  public List<TiendaBloque> findById(Integer tiendabloqueid, Boolean soloPendientes) {
    try {
      SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
      .withProcedureName("usp_SelTiendaBloque")
      .returningResultSet("tiendabloques", 
        BeanPropertyRowMapper.newInstance(TiendaBloque.class));

      MapSqlParameterSource inParams = new MapSqlParameterSource()
      .addValue("p_TiendaBloqueId", tiendabloqueid)
      .addValue("p_SoloPendientes", soloPendientes);

      Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);
      
      return (List<TiendaBloque>) simpleJdbcCallResult.get("tiendabloques");
    } 
    catch (IncorrectResultSizeDataAccessException e) {
      return null;
    }
  }

  //@Override
  public RepositoryResult insert(TiendaBloque tiendabloque) {
    String uspName = (tiendabloque.getTiendaBloqueId() == 0 ? "usp_InsTiendaBloque" : "usp_UpdTiendaBloque");

    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName(uspName);

    MapSqlParameterSource inParams = new MapSqlParameterSource()
    .addValue("p_Nombre", tiendabloque.getNombre())
    .addValue("p_FechaCreacion", tiendabloque.getFechaCreacion())
    //.addValue("p_FechaReverso", tiendabloque.getFechaReverso())
    .addValue("p_UsuarioID", tiendabloque.getUsuarioID());
    //.addValue("p_UsuarioID", usuarioID);

    if (tiendabloque.getTiendaBloqueId() > 0) {
      inParams.addValue("p_TiendaBloqueId", tiendabloque.getTiendaBloqueId());
    }

    Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);

    tiendabloque.setTiendaBloqueId ((Integer) simpleJdbcCallResult.get("out_Id")); 

    return new RepositoryResult(
      1, 
      "OK!", 
      (Integer) simpleJdbcCallResult.get("#update-count-1"), 
      tiendabloque.getTiendaBloqueId().longValue() 
    );
  }

  //@Override
  public RepositoryResult deleteById(Integer tiendabloqueid, Short usuarioID) {
    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName("usp_DelTiendaBloque");

    MapSqlParameterSource inParams = new MapSqlParameterSource()
    .addValue("p_TiendaBloqueId", tiendabloqueid)
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
