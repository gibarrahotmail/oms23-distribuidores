package com.omsdanone.distribuidores.model;

import java.util.Date;
import java.util.Optional;

public class TiendaBloque {
  private Integer m_TiendaBloqueId;
  private String m_Nombre;
  private Date m_FechaCreacion;
  private Optional<Date> m_FechaReverso;
  private Short m_UsuarioID;
  private String m_Usuario;
  private String m_TipoDeRol;  
  private Integer m_Cantidad;

  public TiendaBloque ()
  { }

  public TiendaBloque (Integer p_TiendaBloqueId, String p_Nombre, Date p_FechaCreacion, Optional<Date> p_FechaReverso, Short p_UsuarioID  )
  {
    m_TiendaBloqueId = p_TiendaBloqueId;
    m_Nombre = p_Nombre;
    m_FechaCreacion = p_FechaCreacion;
    m_FechaReverso = p_FechaReverso;
    m_UsuarioID = p_UsuarioID;
  }

  public Integer getTiendaBloqueId()
  {
    return this.m_TiendaBloqueId;
  }
  public void setTiendaBloqueId(Integer value)
  {
    this.m_TiendaBloqueId = value;
  }

  public String getNombre()
  {
    return this.m_Nombre;
  }
  public void setNombre(String value)
  {
    this.m_Nombre = value;
  }

  public Date getFechaCreacion()
  {
    return this.m_FechaCreacion;
  }
  public void setFechaCreacion(Date value)
  {
    this.m_FechaCreacion = value;
  }

  public Optional<Date> getFechaReverso()
  {
    return this.m_FechaReverso;
  }
  public void setFechaReverso(Optional<Date> value)
  {
    this.m_FechaReverso = value;
  }

  public Short getUsuarioID()
  {
    return this.m_UsuarioID;
  }
  public void setUsuarioID(Short value)
  {
    this.m_UsuarioID = value;
  }


  public String getUsuario()
  {
    return this.m_Usuario;
  }
  public void setUsuario(String value)
  {
    this.m_Usuario = value;
  }

  public String getTipoDeRol()
  {
    return this.m_TipoDeRol;
  }
  public void setTipoDeRol(String value)
  {
    this.m_TipoDeRol = value;
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