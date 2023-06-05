package com.omsdanone.distribuidores.model;

public class SubMarca
{
  private Short m_SubMarcaID;
  private String m_Nombre;
  private Byte m_MarcaID;
  private Integer m_Cantidad;

  public SubMarca ()
  { }

  public SubMarca (Short p_SubMarcaID, String p_Nombre, Byte p_MarcaID)
  {
    m_SubMarcaID = p_SubMarcaID;
    m_Nombre = p_Nombre;
    m_MarcaID = p_MarcaID;
  }

  public Short getSubMarcaID()
  {
    return this.m_SubMarcaID;
  }
  public void setSubMarcaID(Short value)
  {
    this.m_SubMarcaID = value;
  }

  public String getNombre()
  {
    return this.m_Nombre;
  }
  public void setNombre(String value)
  {
    this.m_Nombre = value;
  }

  public Byte getMarcaID()
  {
    return this.m_MarcaID;
  }
  public void setMarcaID(Byte value)
  {
    this.m_MarcaID = value;
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
