package com.omsdanone.distribuidores.model;

public class Distribuidor_Producto {
  private Short m_DistribuidorID;
  private Short m_ProductoID;
  private String m_SKU;
  private String m_Producto;
  private Short m_SubMarcaID;
  
  public Distribuidor_Producto ()
  { }

  public Distribuidor_Producto (Short p_DistribuidorID, Short p_ProductoID  )
  {
    m_DistribuidorID = p_DistribuidorID;
    m_ProductoID = p_ProductoID;
  }

  public Short getDistribuidorID()
  {
    return this.m_DistribuidorID;
  }
  public void setDistribuidorID(Short value)
  {
    this.m_DistribuidorID = value;
  }

  public Short getProductoID()
  {
    return this.m_ProductoID;
  }
  public void setProductoID(Short value)
  {
    this.m_ProductoID = value;
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

  public Short getSubMarcaID()
  {
    return this.m_SubMarcaID;
  }
  public void setSubMarcaID(Short value)
  {
    this.m_SubMarcaID = value;
  }
}
