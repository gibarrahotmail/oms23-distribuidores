package com.omsdanone.distribuidores.model;

public class RolDePedido {
  private Short m_RolDePedidoId;
  private String m_Codigo;
  private Byte m_Frecuencia;
  private String m_TipoDeRol;
  private Byte m_HorasEntrega;
  private boolean m_Activo;

  public RolDePedido ()
  { }

  public RolDePedido (Short p_RolDePedidoId, String p_Codigo, Byte p_Frecuencia, String p_TipoDeRol, 
    Byte p_HorasEntrega, Boolean p_Activo)
  {
    m_RolDePedidoId = p_RolDePedidoId;
    m_Codigo = p_Codigo;
    m_Frecuencia = p_Frecuencia;
    m_TipoDeRol = p_TipoDeRol;
    m_HorasEntrega = p_HorasEntrega;
    m_Activo = p_Activo;
  }
  
  public Short getRolDePedidoId()
  {
    return this.m_RolDePedidoId;
  }
  public void setRolDePedidoId(Short value)
  {
    this.m_RolDePedidoId = value;
  }

  public String getCodigo()
  {
    return this.m_Codigo;
  }
  public void setCodigo(String value)
  {
    this.m_Codigo = value;
  }

  public Byte getFrecuencia()
  {
    return this.m_Frecuencia;
  }
  public void setFrecuencia(Byte value)
  {
    this.m_Frecuencia = value;
  }

  public String getTipoDeRol()
  {
    return this.m_TipoDeRol;
  }
  public void setTipoDeRol(String value)
  {
    this.m_TipoDeRol = value;
  }

  public Byte getHorasEntrega()
  {
    return this.m_HorasEntrega;
  }
  public void setHorasEntrega(Byte value)
  {
    this.m_HorasEntrega = value;
  }

  public boolean getActivo()
  {
    return this.m_Activo;
  }
  public void setActivo(Boolean value)
  {
    this.m_Activo = value;
  }


}
