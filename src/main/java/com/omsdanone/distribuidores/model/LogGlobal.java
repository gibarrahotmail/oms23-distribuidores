package com.omsdanone.distribuidores.model;

import java.sql.Date;

public class LogGlobal
{
  private Long m_IdLogGlobal;
  private Short m_UsuarioID;
  private Date m_Registro;
  private String m_Operacion;
  private String m_Descrip;
  private Short m_StatusFinal;
  private String m_Usuario;

  public LogGlobal ()
  { }

  public LogGlobal (Long p_IdLogGlobal, Short p_UsuarioID, Date p_Registro, String p_Operacion, String p_Descrip, 
    Short p_StatusFinal  )
  {
    m_IdLogGlobal = p_IdLogGlobal;
    m_UsuarioID = p_UsuarioID;
    m_Registro = p_Registro;
    m_Operacion = p_Operacion;
    m_Descrip = p_Descrip;
    m_StatusFinal = p_StatusFinal;
  }

  public Long getIdLogGlobal()
  {
    return this.m_IdLogGlobal;
  }
  public void setIdLogGlobal(Long value)
  {
    this.m_IdLogGlobal = value;
  }

  public Short getUsuarioID()
  {
    return this.m_UsuarioID;
  }
  public void setUsuarioID(Short value)
  {
    this.m_UsuarioID = value;
  }

  public Date getRegistro()
  {
    return this.m_Registro;
  }
  public void setRegistro(Date value)
  {
    this.m_Registro = value;
  }

  public String getOperacion()
  {
    return this.m_Operacion;
  }
  public void setOperacion(String value)
  {
    this.m_Operacion = value;
  }

  public String getDescrip()
  {
    return this.m_Descrip;
  }
  public void setDescrip(String value)
  {
    this.m_Descrip = value;
  }

  public Short getStatusFinal()
  {
    return this.m_StatusFinal;
  }
  public void setStatusFinal(Short value)
  {
    this.m_StatusFinal = value;
  }

  public String getUsuario()
  {
    return this.m_Usuario;
  }
  public void setUsuario(String value)
  {
    this.m_Usuario = value;
  }
}