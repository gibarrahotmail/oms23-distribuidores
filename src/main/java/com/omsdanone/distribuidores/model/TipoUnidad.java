package com.omsdanone.distribuidores.model;

public class TipoUnidad {
  private Byte m_TipoUnidadID;
  private String m_Nombre;

  public TipoUnidad ()
  { }

    public TipoUnidad (Byte p_TipoUnidadID, String p_Nombre  )
  {
    m_TipoUnidadID = p_TipoUnidadID;
    m_Nombre = p_Nombre;
  }

  public Byte getTipoUnidadID()
  {
    return this.m_TipoUnidadID;
  }
  public void setTipoUnidadID(Byte value)
  {
    this.m_TipoUnidadID = value;
  }

  public String getNombre()
  {
    return this.m_Nombre;
  }
  public void setNombre(String value)
  {
    this.m_Nombre = value;
  }
  
}
