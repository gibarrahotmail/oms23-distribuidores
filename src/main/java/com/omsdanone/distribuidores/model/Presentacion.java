package com.omsdanone.distribuidores.model;

public class Presentacion {
  private Short m_PresentacionID;
  private String m_Nombre;
  private Integer m_Cantidad;
  private Byte m_MarcaID;

  public Presentacion ()
  { }

  public Presentacion (Short p_PresentacionID, String p_Nombre, Integer p_Cantidad, Byte p_MarcaID)
  {
    m_PresentacionID = p_PresentacionID;
    m_Nombre = p_Nombre;
    m_Cantidad = p_Cantidad;
    m_MarcaID = p_MarcaID;
  }

  public Short getPresentacionID()
  {
    return this.m_PresentacionID;
  }
  public void setPresentacionID(Short value)
  {
    this.m_PresentacionID = value;
  }

  public String getNombre()
  {
    return this.m_Nombre;
  }
  public void setNombre(String value)
  {
    this.m_Nombre = value;
  }

  public Integer getCantidad()
  {
    return this.m_Cantidad;
  }
  public void setCantidad(Integer value)
  {
    this.m_Cantidad = value;
  }

  public Byte getMarcaID()
  {
    return this.m_MarcaID;
  }
  public void setMarcaID(Byte value)
  {
    this.m_MarcaID = value;
  }
}
