package com.omsdanone.distribuidores.model;

public class Perfil {
  private Byte m_PerfilID;
  private String m_Nombre;
  private Integer m_Permisos;

  public Perfil ()
  { }

  public Perfil (Byte p_PerfilID, String p_Nombre, Integer p_Permisos  )
  {
    m_PerfilID = p_PerfilID;
    m_Nombre = p_Nombre;
    m_Permisos = p_Permisos;
  }

  public Byte getPerfilID()
  {
    return this.m_PerfilID;
  }
  public void setPerfilID(Byte value)
  {
    this.m_PerfilID = value;
  }

  public String getNombre()
  {
    return this.m_Nombre;
  }
  public void setNombre(String value)
  {
    this.m_Nombre = value;
  }

  public Integer getPermisos()
  {
    return this.m_Permisos;
  }
  public void setPermisos(Integer value)
  {
    this.m_Permisos = value;
  }

}
