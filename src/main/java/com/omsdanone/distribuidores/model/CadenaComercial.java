package com.omsdanone.distribuidores.model;

public class CadenaComercial {
  private Short m_CadenaComercialId;
  private String m_Codigo;
  private String m_Nombre;
  private boolean m_Activa;
  private Integer m_Cantidad;

  public CadenaComercial ()
  { }

  public CadenaComercial (Short p_CadenaComercialId, String p_Codigo, String p_Nombre, boolean p_Activa)
  {
    m_CadenaComercialId = p_CadenaComercialId;
    m_Codigo = p_Codigo;
    m_Nombre = p_Nombre;
    m_Activa = p_Activa;
  }

  public Short getCadenaComercialId()
  {
    return this.m_CadenaComercialId;
  }
  public void setCadenaComercialId(Short value)
  {
    this.m_CadenaComercialId = value;
  }

  public String getCodigo()
  {
    return this.m_Codigo;
  }
  public void setCodigo(String value)
  {
    this.m_Codigo = value;
  }

  public String getNombre()
  {
    return this.m_Nombre;
  }
  public void setNombre(String value)
  {
    this.m_Nombre = value;
  }

  public boolean getActiva()
  {
    return this.m_Activa;
  }
  public void setActiva(boolean value)
  {
    this.m_Activa = value;
  }

  public Integer getCantidad()
  {
    return this.m_Cantidad;
  }
  public void setCantidad(Integer value)
  {
    this.m_Cantidad = value;
  }
}
