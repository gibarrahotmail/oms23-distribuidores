package com.omsdanone.distribuidores.model;

public class Distribuidor {
  private Short m_DistribuidorID;
  //private Short m_RegionID;
  private String m_NumeroCliente;
  private String m_Contacto;
  private String m_Nombre;
  private String m_Direccion;
  //private Short m_CiudadID;
  //private Byte m_CeDisID;
  private Float m_Credito;
  private boolean m_Activo;
  private boolean m_TransportesPropios;
  private Short m_HorasEntrega;
  private String m_Email;
  //private String m_EmailCC1;
  //private String m_EmailCC2;
  private Byte m_PedidosXSemana;
  private Float m_PcExtraXPedido;
  private String m_SalesGroupId;

  private Short m_RolDePedidoId;
  private String m_CorteHorarioId;
  private Byte m_TipoUnidadID;

  private String m_RolDePedido;
  private String m_TipoUnidad;

  public Distribuidor ()
  { }

  public Distribuidor (Short p_DistribuidorID, //Short p_RegionID, Short p_CiudadID, Byte p_CeDisID, 
    String p_NumeroCliente, String p_Contacto, 
    String p_Nombre, String p_Direccion, Float p_Credito, Boolean p_Activo, 
    Boolean p_TransportesPropios, Short p_HorasEntrega, String p_Email, //String p_EmailCC1, String p_EmailCC2, 
    Byte p_PedidosXSemana, Float p_PcExtraXPedido, String p_SalesGroupId)
  {
    m_DistribuidorID = p_DistribuidorID;
    //m_RegionID = p_RegionID;
    m_NumeroCliente = p_NumeroCliente;
    m_Contacto = p_Contacto;
    m_Nombre = p_Nombre;
    m_Direccion = p_Direccion;
    //m_CiudadID = p_CiudadID;
    //m_CeDisID = p_CeDisID;
    m_Credito = p_Credito;
    m_Activo = p_Activo;
    m_TransportesPropios = p_TransportesPropios;
    m_HorasEntrega = p_HorasEntrega;
    m_Email = p_Email;
    //m_EmailCC1 = p_EmailCC1;
    //m_EmailCC2 = p_EmailCC2;
    m_PedidosXSemana = p_PedidosXSemana;
    m_PcExtraXPedido = p_PcExtraXPedido;
    m_SalesGroupId = p_SalesGroupId;
  }

  public Short getDistribuidorID()
  {
    return this.m_DistribuidorID;
  }
  public void setDistribuidorID(Short value)
  {
    this.m_DistribuidorID = value;
  }

  /*public Short getRegionID()
  {
    return this.m_RegionID;
  }
  public void setRegionID(Short value)
  {
    this.m_RegionID = value;
  }*/

  public String getNumeroCliente()
  {
    return this.m_NumeroCliente;
  }
  public void setNumeroCliente(String value)
  {
    this.m_NumeroCliente = value;
  }

  public String getContacto()
  {
    return this.m_Contacto;
  }
  public void setContacto(String value)
  {
    this.m_Contacto = value;
  }

  public String getNombre()
  {
    return this.m_Nombre;
  }
  public void setNombre(String value)
  {
    this.m_Nombre = value;
  }

  public String getDireccion()
  {
    return this.m_Direccion;
  }
  public void setDireccion(String value)
  {
    this.m_Direccion = value;
  }

  /*public Short getCiudadID()
  {
    return this.m_CiudadID;
  }
  public void setCiudadID(Short value)
  {
    this.m_CiudadID = value;
  }

  public Byte getCeDisID()
  {
    return this.m_CeDisID;
  }
  public void setCeDisID(Byte value)
  {
    this.m_CeDisID = value;
  }*/

  public Float getCredito()
  {
    return this.m_Credito;
  }
  public void setCredito(Float value)
  {
    this.m_Credito = value;
  }

  public boolean getActivo()
  {
    return this.m_Activo;
  }
  public void setActivo(Boolean value)
  {
    this.m_Activo = value;
  }

  public boolean getTransportesPropios()
  {
    return this.m_TransportesPropios;
  }
  public void setTransportesPropios(Boolean value)
  {
    this.m_TransportesPropios = value;
  }

  public Short getHorasEntrega()
  {
    return this.m_HorasEntrega;
  }
  public void setHorasEntrega(Short value)
  {
    this.m_HorasEntrega = value;
  }

  public String getEmail()
  {
    return this.m_Email;
  }
  public void setEmail(String value)
  {
    this.m_Email = value;
  }

  /* public String getEmailCC1()
  {
    return this.m_EmailCC1;
  }
  public void setEmailCC1(String value)
  {
    this.m_EmailCC1 = value;
  }

  public String getEmailCC2()
  {
    return this.m_EmailCC2;
  }
  public void setEmailCC2(String value)
  {
    this.m_EmailCC2 = value;
  } */

  public Byte getPedidosXSemana()
  {
    return this.m_PedidosXSemana;
  }
  public void setPedidosXSemana(Byte value)
  {
    this.m_PedidosXSemana = value;
  }

  public Float getPcExtraXPedido()
  {
    return this.m_PcExtraXPedido;
  }
  public void setPcExtraXPedido(Float value)
  {
    this.m_PcExtraXPedido = value;
  }

  public String getSalesGroupId()
  {
    return this.m_SalesGroupId;
  }
  public void setSalesGroupId(String value)
  {
    this.m_SalesGroupId = value;
  }


  public Short getRolDePedidoId()
  {
    return this.m_RolDePedidoId;
  }
  public void setRolDePedidoId(Short value)
  {
    this.m_RolDePedidoId = value;
  }

  public String getCorteHorarioId()
  {
    return this.m_CorteHorarioId;
  }
  public void setCorteHorarioId(String value)
  {
    this.m_CorteHorarioId = value;
  }

  public Byte getTipoUnidadID()
  {
    return this.m_TipoUnidadID;
  }
  public void setTipoUnidadID(Byte value)
  {
    this.m_TipoUnidadID = value;
  }


  public String getRolDePedido()
  {
    return this.m_RolDePedido;
  }
  public void setRolDePedido(String value)
  {
    this.m_RolDePedido = value;
  }  

  public String getTipoUnidad()
  {
    return this.m_TipoUnidad;
  }
  public void setTipoUnidad(String value)
  {
    this.m_TipoUnidad = value;
  }  
}
