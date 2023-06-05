package com.omsdanone.distribuidores.model;
//import java.util.Optional;

public class Producto {
  private Short m_ProductoID;
  private Short m_SubMarcaID;
  private Short m_PresentacionID;
  private String m_SKU;
  private String m_Nombre;
  private Integer m_PiezasXCaja;
  private Integer m_CajasXTarima;
  private Float m_PesoXCaja;
  private Integer m_CamasXTarima;
  private Boolean m_Activo;
  private Short m_FamiliaID;
  private String m_BarCode;
  private Float m_PesoXPieza;

  private String m_Presentacion;
  private String m_Submarca;
  private String m_Familia;
  private String m_Descrip;
  
  public Producto ()
  { }
  
  public Producto (Short p_ProductoID, Short p_SubMarcaID, Short p_PresentacionID, String p_SKU, String p_Nombre, 
    Integer p_PiezasXCaja, Integer p_CajasXTarima, Float p_PesoXCaja, Integer p_CamasXTarima, Boolean p_Activo, 
    Short p_FamiliaID, String p_BarCode, Float p_PesoXPieza  )
  {
    m_ProductoID = p_ProductoID;
    m_SubMarcaID = p_SubMarcaID;
    m_PresentacionID = p_PresentacionID;
    m_SKU = p_SKU;
    m_Nombre = p_Nombre;
    m_PiezasXCaja = p_PiezasXCaja;
    m_CajasXTarima = p_CajasXTarima;
    m_PesoXCaja = p_PesoXCaja;
    m_CamasXTarima = p_CamasXTarima;
    m_Activo = p_Activo;
    m_FamiliaID = p_FamiliaID;
    m_BarCode = p_BarCode;
    m_PesoXPieza = p_PesoXPieza;
  }

  public Short getProductoID()
  {
    return this.m_ProductoID;
  }
  public void setProductoID(Short value)
  {
    this.m_ProductoID = value;
  }

  public Short getSubMarcaID()
  {
    return this.m_SubMarcaID;
  }
  public void setSubMarcaID(Short value)
  {
    this.m_SubMarcaID = value;
  }

  public Short getPresentacionID()
  {
    return this.m_PresentacionID;
  }
  public void setPresentacionID(Short value)
  {
    this.m_PresentacionID = value;
  }

  public String getSKU()
  {
    return this.m_SKU;
  }
  public void setSKU(String value)
  {
    this.m_SKU = value;
  }

  public String getNombre()
  {
    return this.m_Nombre;
  }
  public void setNombre(String value)
  {
    this.m_Nombre = value;
  }

  public Integer getPiezasXCaja()
  {
    return this.m_PiezasXCaja;
  }
  public void setPiezasXCaja(Integer value)
  {
    this.m_PiezasXCaja = value;
  }

  public Integer getCajasXTarima()
  {
    return this.m_CajasXTarima;
  }
  public void setCajasXTarima(Integer value)
  {
    this.m_CajasXTarima = value;
  }

  public Float getPesoXCaja()
  {
    return this.m_PesoXCaja;
  }
  public void setPesoXCaja(Float value)
  {
    this.m_PesoXCaja = value;
  }

  public Integer getCamasXTarima()
  {
    return this.m_CamasXTarima;
  }
  public void setCamasXTarima(Integer value)
  {
    this.m_CamasXTarima = value;
  }

  public Boolean getActivo()
  {
    return this.m_Activo;
  }
  public void setActivo(Boolean value)
  {
    this.m_Activo = value;
  }

  public Short getFamiliaID()
  {
    return this.m_FamiliaID;
  }
  public void setFamiliaID(Short value)
  {
    this.m_FamiliaID = value;
  }

  public String getBarCode()
  {
    return this.m_BarCode;
  }
  public void setBarCode(String value)
  {
    this.m_BarCode = value;
  }

  public Float getPesoXPieza()
  {
    return this.m_PesoXPieza;
  }
  public void setPesoXPieza(Float value)
  {
    this.m_PesoXPieza = value;
  }

  
  public String getPresentacion()
  {
    return this.m_Presentacion;
  }
  public void setPresentacion(String value)
  {
    this.m_Presentacion = value;
  }

  public String getSubmarca()
  {
    return this.m_Submarca;
  }
  public void setSubmarca(String value)
  {
    this.m_Submarca = value;
  }

  public String getFamilia()
  {
    return this.m_Familia;
  }
  public void setFamilia(String value)
  {
    this.m_Familia = value;
  }

  public String getDescrip()
  {
    return this.m_Descrip;
  }
  public void setDescrip(String value)
  {
    this.m_Descrip = value;
  }

}
