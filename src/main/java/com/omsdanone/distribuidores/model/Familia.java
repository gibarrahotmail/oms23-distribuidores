package com.omsdanone.distribuidores.model;

public class Familia {
  private Byte m_FamiliaID;
  private String m_Nombre;
  private Integer m_Cantidad;
  private Byte m_MarcaID;

  public Familia ()
  { }

  public Familia (Byte p_FamiliaID, String p_Nombre, Byte p_MarcaID)
  {
    m_FamiliaID = p_FamiliaID;
    m_Nombre = p_Nombre;
    m_MarcaID = p_MarcaID;
  }

  public Byte getFamiliaID()
  {
    return this.m_FamiliaID;
  }
  public void setFamiliaID(Byte value)
  {
    this.m_FamiliaID = value;
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
