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
import com.omsdanone.distribuidores.model.Producto;

@Repository
public class ProductoRepository {  // implements IProducto 
  @Autowired
  private JdbcTemplate jdbcTemplate;

  //@Override
  @SuppressWarnings("unchecked")
  public List<Producto> findById(Short productoid, Short submarcaid, Short presentacionid,
  short familiaid, Boolean soloActivos) {
    try {
      SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
      .withProcedureName("usp_SelProducto")
      .returningResultSet("productos", 
        BeanPropertyRowMapper.newInstance(Producto.class));

      MapSqlParameterSource inParams = new MapSqlParameterSource()
      .addValue("p_ProductoID", productoid)
      .addValue("p_SubMarcaID", submarcaid)
      .addValue("p_PresentacionID", presentacionid)
      .addValue("p_FamiliaID", (byte)familiaid)
      .addValue("p_SoloActivos", soloActivos);

      Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);
      
      return (List<Producto>) simpleJdbcCallResult.get("productos");
    } 
    catch (IncorrectResultSizeDataAccessException e) {
      return null;
    }
  }

  //@Override
  public RepositoryResult insert(Producto producto, Short usuarioID) {
    String uspName = (producto.getProductoID() == 0 ? "usp_InsProducto" : "usp_UpdProducto");

    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName(uspName);

    MapSqlParameterSource inParams = new MapSqlParameterSource()
    .addValue("p_SubMarcaID", producto.getSubMarcaID())
    .addValue("p_PresentacionID", producto.getPresentacionID())
    .addValue("p_SKU", producto.getSKU())
    .addValue("p_Nombre", producto.getNombre())
    .addValue("p_PiezasXCaja", producto.getPiezasXCaja())
    .addValue("p_CajasXTarima", producto.getCajasXTarima())
    .addValue("p_PesoXCaja", producto.getPesoXCaja())
    .addValue("p_CamasXTarima", producto.getCamasXTarima())
    .addValue("p_Activo", producto.getActivo())
    .addValue("p_FamiliaID", producto.getFamiliaID())
    .addValue("p_BarCode", producto.getBarCode())
    .addValue("p_PesoXPieza", producto.getPesoXPieza())
    .addValue("p_Innovacion", producto.getInnovacion())
    .addValue("p_UsuarioID", usuarioID);

    if (producto.getProductoID() > 0) {
      inParams.addValue("p_ProductoID", producto.getProductoID());
    }

    Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(inParams);

    producto.setProductoID ( ( (Number) simpleJdbcCallResult.get("out_Id") ).shortValue() ); 

    return new RepositoryResult(
      1, 
      "OK!", 
      (Integer) simpleJdbcCallResult.get("#update-count-1"), 
      producto.getProductoID().longValue() 
    );
  }

  //@Override
  public RepositoryResult deleteById(Short productoid, Short usuarioID) {
    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withProcedureName("usp_DelProducto");

    MapSqlParameterSource inParams = new MapSqlParameterSource()
    .addValue("p_ProductoID", productoid)
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

