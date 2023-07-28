package com.omsdanone.distribuidores.model;

public class Usuario_Tienda {
  private Short m_UsuarioId;
  private Integer m_TiendaId;
  private String m_Usuario;
  private String m_Tienda;
  private boolean m_TiendaActiva;
  private boolean m_UsuarioActivo;
  private Short m_CadenaFormatoId;

  public Usuario_Tienda ()
  { }

  public Usuario_Tienda (Short p_UsuarioId, Integer p_TiendaId  )
  {
    m_UsuarioId = p_UsuarioId;
    m_TiendaId = p_TiendaId;
  }

  public Short getUsuarioId()
  {
    return this.m_UsuarioId;
  }
  public void setUsuarioId(Short value)
  {
    this.m_UsuarioId = value;
  }

  public Integer getTiendaId()
  {
    return this.m_TiendaId;
  }
  public void setTiendaId(Integer value)
  {
    this.m_TiendaId = value;
  }


  public String getUsuario()
  {
    return this.m_Usuario;
  }
  public void setUsuario(String value)
  {
    this.m_Usuario = value;
  }

  public String getTienda()
  {
    return this.m_Tienda;
  }
  public void setTienda(String value)
  {
    this.m_Tienda = value;
  }

  public Boolean getTiendaActiva()
  {
    return this.m_TiendaActiva;
  }
  public void setTiendaActiva(Boolean value)
  {
    this.m_TiendaActiva = value;
  }

  public Boolean getUsuarioActivo()
  {
    return this.m_UsuarioActivo;
  }
  public void setUsuarioActivo(Boolean value)
  {
    this.m_UsuarioActivo = value;
  }  

  public Short getCadenaFormatoId()
  {
    return this.m_CadenaFormatoId;
  }
  public void setCadenaFormatoId(Short value)
  {
    this.m_CadenaFormatoId = value;
  }

}
