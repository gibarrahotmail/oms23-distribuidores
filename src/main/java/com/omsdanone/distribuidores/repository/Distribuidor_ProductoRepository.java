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
import com.omsdanone.distribuidores.model.Distribuidor_Producto;

@Repository
public class Distribuidor_ProductoRepository {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  //@Override
  @SuppressWarnings("unchecked")
  public List<Distribuidor_Producto> findById(Short distribuidorid) {
    try {
      SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
      .withProcedureName("usp_SelDistribuidor_Producto")
      .returningResultSet("distribuidor_productos", 
        BeanPropertyRowMapper.newInstance(Distribuidor_Producto.class));

      MapSqlParameterSource inParams = new MapSqlParameterSource()
      .addValue("p_DistribuidorID",distribuidorid );

      Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);
      
      return (List<Distribuidor_Producto>) simpleJdbcCallResult.get("distribuidor_productos");
    } 
    catch (IncorrectResultSizeDataAccessException e) {
      return null;
    }
  }

  //@Override
  public RepositoryResult insert(Distribuidor_Producto distribuidor_producto, Short usuarioID) {
    String uspName = "usp_InsDistribuidor_Producto";  //( == 0 ? "usp_InsDistribuidor_Producto" : "usp_UpdDistribuidor_Producto");

    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName(uspName);

    MapSqlParameterSource inParams = new MapSqlParameterSource()
    .addValue("p_DistribuidorID", distribuidor_producto.getDistribuidorID())
    .addValue("p_ProductoID", distribuidor_producto.getProductoID())
    .addValue("p_UsuarioID", usuarioID)
    .addValue("p_SubMarcaID", distribuidor_producto.getSubMarcaID())
    .addValue("p_SKU", distribuidor_producto.getSKU());

    /*if ( > 0) {
      inParams
    } */

    Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);

    distribuidor_producto.setProductoID ( ( (Number) simpleJdbcCallResult.get("out_Id") ).shortValue() ); 

    return new RepositoryResult(
      1, 
      "OK!", 
      (Integer) simpleJdbcCallResult.get("#update-count-1"), 
      distribuidor_producto.getProductoID().longValue() 
    );
  }

  //@Override
  public RepositoryResult deleteById(Short distribuidorid, Short productoid, Short usuarioID, Short submarcaid) {
    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName("usp_DelDistribuidor_Producto");

    MapSqlParameterSource inParams = new MapSqlParameterSource()
    .addValue("p_DistribuidorID", distribuidorid)
    .addValue("p_ProductoID", productoid)
    .addValue("p_UsuarioID", usuarioID)
    .addValue("p_SubMarcaID", submarcaid);

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
