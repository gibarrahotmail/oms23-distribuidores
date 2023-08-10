package com.omsdanone.distribuidores.model;

public class TiendaBloqueDet {
  private Integer m_TiendaBloqueId;
  private Integer m_TiendaId;
  private Short m_RolDePedidoId_01;
  private Byte m_UnidadId_01;
  private Short m_RolDePedidoId_02;
  private Byte m_UnidadId_02;
  private Short m_RolDePedidoId_1;
  private Byte m_UnidadId_1;
  private Short m_RolDePedidoId_2;
  private Byte m_UnidadId_2;
  
  private String m_Codigo;
  private String m_Tienda;

  public TiendaBloqueDet ()
  { }

  public TiendaBloqueDet (Integer p_TiendaBloqueId, Integer p_TiendaId, Short p_RolDePedidoId_01, Byte p_UnidadId_01, Short p_RolDePedidoId_02, Byte p_UnidadId_02, Short p_RolDePedidoId_1, Byte p_UnidadId_1, Short p_RolDePedidoId_2, Byte p_UnidadId_2  )
  {
    m_TiendaBloqueId = p_TiendaBloqueId;
    m_TiendaId = p_TiendaId;
    m_RolDePedidoId_01 = p_RolDePedidoId_01;
    m_UnidadId_01 = p_UnidadId_01;
    m_RolDePedidoId_02 = p_RolDePedidoId_02;
    m_UnidadId_02 = p_UnidadId_02;
    m_RolDePedidoId_1 = p_RolDePedidoId_1;
    m_UnidadId_1 = p_UnidadId_1;
    m_RolDePedidoId_2 = p_RolDePedidoId_2;
    m_UnidadId_2 = p_UnidadId_2;
  }

  public Integer getTiendaBloqueId()
  {
    return this.m_TiendaBloqueId;
  }
  public void setTiendaBloqueId(Integer value)
  {
    this.m_TiendaBloqueId = value;
  }

  public Integer getTiendaId()
  {
    return this.m_TiendaId;
  }
  public void setTiendaId(Integer value)
  {
    this.m_TiendaId = value;
  }

  public Short getRolDePedidoId_01()
  {
    return this.m_RolDePedidoId_01;
  }
  public void setRolDePedidoId_01(Short value)
  {
    this.m_RolDePedidoId_01 = value;
  }

  public Byte getUnidadId_01()
  {
    return this.m_UnidadId_01;
  }
  public void setUnidadId_01(Byte value)
  {
    this.m_UnidadId_01 = value;
  }

  public Short getRolDePedidoId_02()
  {
    return this.m_RolDePedidoId_02;
  }
  public void setRolDePedidoId_02(Short value)
  {
    this.m_RolDePedidoId_02 = value;
  }

  public Byte getUnidadId_02()
  {
    return this.m_UnidadId_02;
  }
  public void setUnidadId_02(Byte value)
  {
    this.m_UnidadId_02 = value;
  }

  public Short getRolDePedidoId_1()
  {
    return this.m_RolDePedidoId_1;
  }
  public void setRolDePedidoId_1(Short value)
  {
    this.m_RolDePedidoId_1 = value;
  }

  public Byte getUnidadId_1()
  {
    return this.m_UnidadId_1;
  }
  public void setUnidadId_1(Byte value)
  {
    this.m_UnidadId_1 = value;
  }

  public Short getRolDePedidoId_2()
  {
    return this.m_RolDePedidoId_2;
  }
  public void setRolDePedidoId_2(Short value)
  {
    this.m_RolDePedidoId_2 = value;
  }

  public Byte getUnidadId_2()
  {
    return this.m_UnidadId_2;
  }
  public void setUnidadId_2(Byte value)
  {
    this.m_UnidadId_2 = value;
  }


  public String getCodigo()
  {
    return this.m_Codigo;
  }
  public void setCodigo(String value)
  {
    this.m_Codigo = value;
  }
  
  public String getTienda()
  {
    return this.m_Tienda;
  }
  public void setTiendaId(String value)
  {
    this.m_Tienda = value;
  }  
}
