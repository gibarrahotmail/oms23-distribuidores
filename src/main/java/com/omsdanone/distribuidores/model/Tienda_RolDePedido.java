package com.omsdanone.distribuidores.model;

import java.sql.Date;
import java.util.Optional;

public class Tienda_RolDePedido {
  private Integer m_TiendaId;
  private Byte m_PedidoTipoId;
  private Short m_RolDePedidoId;
  private Date m_FechaActivacion;
  private Optional<Date> m_FechaDesactivacion;

  public Tienda_RolDePedido ()
  { }

  public Tienda_RolDePedido (Integer p_TiendaId, Byte p_PedidoTipoId, Short p_RolDePedidoId, Date p_FechaActivacion, 
    Optional<Date> p_FechaDesactivacion)
  {
    m_TiendaId = p_TiendaId;
    m_PedidoTipoId = p_PedidoTipoId;
    m_RolDePedidoId = p_RolDePedidoId;
    m_FechaActivacion = p_FechaActivacion;
    m_FechaDesactivacion = p_FechaDesactivacion;
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

  public Short getRolDePedidoId()
  {
    return this.m_RolDePedidoId;
  }
  public void setRolDePedidoId(Short value)
  {
    this.m_RolDePedidoId = value;
  }

  public Date getFechaActivacion()
  {
    return this.m_FechaActivacion;
  }
  public void setFechaActivacion(Date value)
  {
    this.m_FechaActivacion = value;
  }

  public Optional<Date> getFechaDesactivacion()
  {
    return this.m_FechaDesactivacion;
  }
  public void setFechaDesactivacion(Optional<Date> value)
  {
    this.m_FechaDesactivacion = value;
  }

}
