package com.omsdanone.distribuidores.model;

public class Tienda_Unidad {
  private Integer m_TiendaId;
  private Byte m_PedidoTipoId;
  private Byte m_UnidadId;

  public Tienda_Unidad ()
  { }

  public Tienda_Unidad (Integer p_TiendaId, Byte p_PedidoTipoId, Byte p_UnidadId  )
  {
    m_TiendaId = p_TiendaId;
    m_PedidoTipoId = p_PedidoTipoId;
    m_UnidadId = p_UnidadId;
  }

  public Integer getTiendaId()
  {
    return this.m_TiendaId;
  }
  public void setTiendaId(Integer value)
  {
    this.m_TiendaId = value;
  }

  public Byte getPedidoTipoId()
  {
    return this.m_PedidoTipoId;
  }
  public void setPedidoTipoId(Byte value)
  {
    this.m_PedidoTipoId = value;
  }

  public Byte getUnidadId()
  {
    return this.m_UnidadId;
  }
  public void setUnidadId(Byte value)
  {
    this.m_UnidadId = value;
  }

}
