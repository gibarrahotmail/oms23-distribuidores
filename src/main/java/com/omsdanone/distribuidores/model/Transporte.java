package com.omsdanone.distribuidores.model;

public class Transporte {
  private Short m_TransporteID;
  private String m_Nombre;
  private Integer m_FT;
  private Integer m_Capacidad;
  private Float m_PesoTotalKgs;
  private Byte m_Entarimado;
  private boolean m_PerteneceALaPlanta;
  private Byte m_MarcaID;

  public Transporte ()
  { }

  public Transporte (Short p_TransporteID, String p_Nombre, Integer p_FT, Integer p_Capacidad, Float p_PesoTotalKgs, 
    Byte p_Entarimado, Boolean p_PerteneceALaPlanta, Byte p_MarcaID)
  {
    m_TransporteID = p_TransporteID;
    m_Nombre = p_Nombre;
    m_FT = p_FT;
    m_Capacidad = p_Capacidad;
    m_PesoTotalKgs = p_PesoTotalKgs;
    m_Entarimado = p_Entarimado;
    m_PerteneceALaPlanta = p_PerteneceALaPlanta;
    m_MarcaID = p_MarcaID;
  }

  public Short getTransporteID()
  {
    return this.m_TransporteID;
  }
  public void setTransporteID(Short value)
  {
    this.m_TransporteID = value;
  }

  public String getNombre()
  {
    return this.m_Nombre;
  }
  public void setNombre(String value)
  {
    this.m_Nombre = value;
  }

  public Integer getFT()
  {
    return this.m_FT;
  }
  public void setFT(Integer value)
  {
    this.m_FT = value;
  }

  public Integer getCapacidad()
  {
    return this.m_Capacidad;
  }
  public void setCapacidad(Integer value)
  {
    this.m_Capacidad = value;
  }

  public Float getPesoTotalKgs()
  {
    return this.m_PesoTotalKgs;
  }
  public void setPesoTotalKgs(Float value)
  {
    this.m_PesoTotalKgs = value;
  }

  public Byte getEntarimado()
  {
    return this.m_Entarimado;
  }
  public void setEntarimado(Byte value)
  {
    this.m_Entarimado = value;
  }

  public boolean getPerteneceALaPlanta()
  {
    return this.m_PerteneceALaPlanta;
  }
  public void setPerteneceALaPlanta(Boolean value)
  {
    this.m_PerteneceALaPlanta = value;
  }

  public Byte getMarcaID()
  {
    return this.m_MarcaID;
  }
  public void setMarcaID(Byte value)
  {
    this.m_MarcaID = value;
  }

}
