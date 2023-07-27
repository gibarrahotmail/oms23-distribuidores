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
import com.omsdanone.distribuidores.model.Tienda_Producto;

@Repository
public class Tienda_ProductoRepository {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  //@Override
  @SuppressWarnings("unchecked")
  public List<Tienda_Producto> findById(Integer tiendaid ) {
    try {
      SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
      .withProcedureName("usp_SelTienda_Producto")
      .returningResultSet("tienda_productos", 
        BeanPropertyRowMapper.newInstance(Tienda_Producto.class));

      MapSqlParameterSource inParams = new MapSqlParameterSource()
      .addValue("p_TiendaId", tiendaid);

      Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);
      
      return (List<Tienda_Producto>) simpleJdbcCallResult.get("tienda_productos");
    } 
    catch (IncorrectResultSizeDataAccessException e) {
      return null;
    }
  }

  //@Override
  public RepositoryResult insert(Tienda_Producto tienda_producto, Short cadenaformatoid, Short usuarioID) {
    String uspName = "usp_InsTienda_Producto";  //( == 0 ? "usp_InsTienda_Producto" : "usp_UpdTienda_Producto");

    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName(uspName);

    MapSqlParameterSource inParams = new MapSqlParameterSource()
    .addValue("p_TiendaId", tienda_producto.getTiendaId())
    .addValue("p_ProductoID", tienda_producto.getProductoID())
    .addValue("p_FechaActivacion", tienda_producto.getFechaActivacion())
    //.addValue("p_FechaDesactivacion", tienda_producto.getFechaDesactivacion())
    .addValue("p_UsuarioID", usuarioID)
    .addValue("p_SubMarcaID", tienda_producto.getSubMarcaID())
    .addValue("p_BarCode", tienda_producto.getSKU())
    .addValue("p_CadenaFormatoID", cadenaformatoid);

    //if ( > 0) {
    //  inParams
    //}

    Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);

    //tienda_producto.set ((void) simpleJdbcCallResult.get("out_Id")); 

    return new RepositoryResult(
      1, 
      "OK!", 
      (Integer) simpleJdbcCallResult.get("#update-count-1"), 
      tienda_producto.getTiendaId().longValue() 
    );
  }

  //@Override
  public RepositoryResult deleteById(Integer tiendaid, Short productoID, Short usuarioID, Short submarcaID) {
    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName("usp_DelTienda_Producto");

    MapSqlParameterSource inParams = new MapSqlParameterSource()
    .addValue("p_TiendaId", tiendaid)
    .addValue("p_ProductoID", productoID)    
    .addValue("p_UsuarioID", usuarioID)
    .addValue("p_SubMarcaID", submarcaID);

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
