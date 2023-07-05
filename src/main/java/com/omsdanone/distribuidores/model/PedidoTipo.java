package com.omsdanone.distribuidores.model;

public class PedidoTipo {
  private Byte m_PedidoTipoId;
  private String m_Codigo;
  private String m_Nombre;

  public PedidoTipo ()
  { }

  public PedidoTipo (Byte p_PedidoTipoId, String p_Codigo, String p_Nombre  )
  {
    m_PedidoTipoId = p_PedidoTipoId;
    m_Codigo = p_Codigo;
    m_Nombre = p_Nombre;
  }

  public Byte getPedidoTipoId()
  {
    return this.m_PedidoTipoId;
  }
  public void setPedidoTipoId(Byte value)
  {
    this.m_PedidoTipoId = value;
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

}
