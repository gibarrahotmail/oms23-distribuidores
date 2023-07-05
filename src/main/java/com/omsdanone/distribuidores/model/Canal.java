package com.omsdanone.distribuidores.model;

public class Canal {
  private Byte m_CanalId;
  private String m_Nombre;
  private String m_SAPcodigo;

  public Canal ()
  { }

  public Canal (Byte p_CanalId, String p_Nombre, String p_SAPcodigo  )
  {
    m_CanalId = p_CanalId;
    m_Nombre = p_Nombre;
    m_SAPcodigo = p_SAPcodigo;
  }

  public Byte getCanalId()
  {
    return this.m_CanalId;
  }
  public void setCanalId(Byte value)
  {
    this.m_CanalId = value;
  }

  public String getNombre()
  {
    return this.m_Nombre;
  }
  public void setNombre(String value)
  {
    this.m_Nombre = value;
  }

  public String getSAPcodigo()
  {
    return this.m_SAPcodigo;
  }
  public void setSAPcodigo(String value)
  {
    this.m_SAPcodigo = value;
  }

}
