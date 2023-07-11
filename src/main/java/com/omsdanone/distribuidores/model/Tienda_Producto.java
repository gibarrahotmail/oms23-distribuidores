package com.omsdanone.distribuidores.model;

import java.sql.Date;
import java.util.Optional;

public class Tienda_Producto {
  private Integer m_TiendaId;
  private Short m_ProductoID;
  private Date m_FechaActivacion;
  private Optional<Date> m_FechaDesactivacion;
  private String m_SKU;
  private String m_Producto;
  private Boolean m_Activo;
  private Short m_SubMarcaID;
  

  public Tienda_Producto ()
  { }

  public Tienda_Producto (Integer p_TiendaId, Short p_ProductoID, Date p_FechaActivacion, 
    Optional<Date> p_FechaDesactivacion  )
  {
    m_TiendaId = p_TiendaId;
    m_ProductoID = p_ProductoID;
    m_FechaActivacion = p_FechaActivacion;
    m_FechaDesactivacion = p_FechaDesactivacion;
  }

  public Integer getTiendaId()
  {
    return this.m_TiendaId;
  }
  public void setTiendaId(Integer value)
  {
    this.m_TiendaId = value;
  }

  public Short getProductoID()
  {
    return this.m_ProductoID;
  }
  public void setProductoID(Short value)
  {
    this.m_ProductoID = value;
  }

  public Date getFechaActivacion()
  {
    return this.m_FechaActivacion;
  }
  public void setFechaActivacion(Date value)
  {
    this.m_FechaActivacion = value;
  }

  public Optional<Date> getFechaDesactivacion()
  {
    return this.m_FechaDesactivacion;
  }
  public void setFechaDesactivacion(Optional<Date> value)
  {
    this.m_FechaDesactivacion = value;
  }

  public String getSKU()
  {
    return this.m_SKU;
  }
  public void setSKU(String value)
  {
    this.m_SKU = value;
  }

  public String getProducto()
  {
    return this.m_Producto;
  }
  public void setProducto(String value)
  {
    this.m_Producto = value;
  }

  public Boolean getActivo()
  {
    return this.m_Activo;
  }
  public void setActivo(Boolean value)
  {
    this.m_Activo = value;
  }


  public Short getSubMarcaID()
  {
    return this.m_SubMarcaID;
  }
  public void setSubMarcaID(Short value)
  {
    this.m_SubMarcaID = value;
  }

}
