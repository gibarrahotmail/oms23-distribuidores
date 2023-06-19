package com.omsdanone.distribuidores.model;

public class CorteHorario {
  private String m_CorteHorarioId;
  private String m_Descripcion;

  public CorteHorario ()
  { }

  public CorteHorario (String p_CorteHorarioId, String p_Descripcion  )
  {
    m_CorteHorarioId = p_CorteHorarioId;
    m_Descripcion = p_Descripcion;
  }

  public String getCorteHorarioId()
  {
    return this.m_CorteHorarioId;
  }
  public void setCorteHorarioId(String value)
  {
    this.m_CorteHorarioId = value;
  }

  public String getDescripcion()
  {
    return this.m_Descripcion;
  }
  public void setDescripcion(String value)
  {
    this.m_Descripcion = value;
  }

}
