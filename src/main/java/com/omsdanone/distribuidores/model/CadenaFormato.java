package com.omsdanone.distribuidores.model;

public class CadenaFormato {
  private Short m_CadenaFormatoId;
  private String m_Codigo;
  private String m_Nombre;
  private boolean m_Activa;
  private Short m_CadenaComercialId;
  private Byte m_CanalId;

  public CadenaFormato ()
  { }

  public CadenaFormato (Short p_CadenaFormatoId, String p_Codigo, String p_Nombre, boolean p_Activa, 
    Short p_CadenaComercialId, Byte p_CanalId  )
  {
    m_CadenaFormatoId = p_CadenaFormatoId;
    m_Codigo = p_Codigo;
    m_Nombre = p_Nombre;
    m_Activa = p_Activa;
    m_CadenaComercialId = p_CadenaComercialId;
    m_CanalId = p_CanalId;
  }
  
  public Short getCadenaFormatoId()
  {
    return this.m_CadenaFormatoId;
  }
  public void setCadenaFormatoId(Short value)
  {
    this.m_CadenaFormatoId = value;
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

  public Short getCadenaComercialId()
  {
    return this.m_CadenaComercialId;
  }
  public void setCadenaComercialId(Short value)
  {
    this.m_CadenaComercialId = value;
  }

  public Byte getCanalId()
  {
    return this.m_CanalId;
  }
  public void setCanalId(Byte value)
  {
    this.m_CanalId = value;
  }

}
