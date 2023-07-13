package com.omsdanone.distribuidores.model;

public class Tienda {
  private Integer m_TiendaId;
  private String m_Codigo;
  private String m_Nombre;
  private String m_Calle;
  private String m_Colonia;
  private String m_Delegacion;
  private String m_CP;
  private Byte m_EntidadFederativaId;
  private String m_Ciudad;
  private boolean m_Activa;
  private Short m_CadenaComercialId;
  private Byte m_RegionID;
  private Byte m_SectorID;
  private String m_CorteHorarioId;
  private Short m_CadenaFormatoId;
  private String m_CadenaComercial;
  private String m_CadenaFormato;
  private String m_TipoDeRol;
  private Short m_RolDePedidoId1;
  private Short m_RolDePedidoId2;
  private Byte m_UnidadId1;
  private Byte m_UnidadId2;

  public Tienda ()
  { }

  public Tienda (Integer p_TiendaId, String p_Codigo, String p_Nombre, String p_Calle, String p_Colonia, 
    String p_Delegacion, String p_CP, Byte p_EntidadFederativaId, String p_Ciudad, boolean p_Activa, 
    Short p_CadenaComercialId, Byte p_RegionID, Byte p_SectorID, String p_CorteHorarioId, 
    Short p_CadenaFormatoId)
  {
    m_TiendaId = p_TiendaId;
    m_Codigo = p_Codigo;
    m_Nombre = p_Nombre;
    m_Calle = p_Calle;
    m_Colonia = p_Colonia;
    m_Delegacion = p_Delegacion;
    m_CP = p_CP;
    m_EntidadFederativaId = p_EntidadFederativaId;
    m_Ciudad = p_Ciudad;
    m_Activa = p_Activa;
    m_CadenaComercialId = p_CadenaComercialId;
    m_RegionID = p_RegionID;
    m_SectorID = p_SectorID;
    m_CorteHorarioId = p_CorteHorarioId;
    m_CadenaFormatoId = p_CadenaFormatoId;
  }

  public Integer getTiendaId()
  {
    return this.m_TiendaId;
  }
  public void setTiendaId(Integer value)
  {
    this.m_TiendaId = value;
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

  public String getCalle()
  {
    return this.m_Calle;
  }
  public void setCalle(String value)
  {
    this.m_Calle = value;
  }

  public String getColonia()
  {
    return this.m_Colonia;
  }
  public void setColonia(String value)
  {
    this.m_Colonia = value;
  }

  public String getDelegacion()
  {
    return this.m_Delegacion;
  }
  public void setDelegacion(String value)
  {
    this.m_Delegacion = value;
  }

  public String getCP()
  {
    return this.m_CP;
  }
  public void setCP(String value)
  {
    this.m_CP = value;
  }

  public Byte getEntidadFederativaId()
  {
    return this.m_EntidadFederativaId;
  }
  public void setEntidadFederativaId(Byte value)
  {
    this.m_EntidadFederativaId = value;
  }

  public String getCiudad()
  {
    return this.m_Ciudad;
  }
  public void setCiudad(String value)
  {
    this.m_Ciudad = value;
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

  public Byte getRegionID()
  {
    return this.m_RegionID;
  }
  public void setRegionID(Byte value)
  {
    this.m_RegionID = value;
  }

  public Byte getSectorID()
  {
    return this.m_SectorID;
  }
  public void setSectorID(Byte value)
  {
    this.m_SectorID = value;
  }

  public String getCorteHorarioId()
  {
    return this.m_CorteHorarioId;
  }
  public void setCorteHorarioId(String value)
  {
    this.m_CorteHorarioId = value;
  }

  public Short getCadenaFormatoId()
  {
    return this.m_CadenaFormatoId;
  }
  public void setCadenaFormatoId(Short value)
  {
    this.m_CadenaFormatoId = value;
  }
  

 public String getCadenaComercial()
  {
    return this.m_CadenaComercial;
  }
  public void setCadenaComercial(String value)
  {
    this.m_CadenaComercial = value;
  }

 public String getCadenaFormato()
  {
    return this.m_CadenaFormato;
  }
  public void setCadenaFormato(String value)
  {
    this.m_CadenaFormato = value;
  }


  public String getTipoDeRol()
  {
    return this.m_TipoDeRol;
  }
  public void setTipoDeRol(String value)
  {
    this.m_TipoDeRol = value;
  }


  public Short getRolDePedidoId1()
  {
    return this.m_RolDePedidoId1;
  }
  public void setRolDePedidoId1(Short value)
  {
    this.m_RolDePedidoId1 = value;
  }

  public Short getRolDePedidoId2()
  {
    return this.m_RolDePedidoId2;
  }
  public void setRolDePedidoId2(Short value)
  {
    this.m_RolDePedidoId2 = value;
  }


  public Byte getUnidadId1()
  {
    return this.m_UnidadId1;
  }
  public void setUnidadId1(Byte value)
  {
    this.m_UnidadId1 = value;
  }

  public Byte getUnidadId2()
  {
    return this.m_UnidadId2;
  }
  public void setUnidadId2(Byte value)
  {
    this.m_UnidadId2 = value;
  }  

}
