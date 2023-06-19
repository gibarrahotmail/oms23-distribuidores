package com.omsdanone.distribuidores.model;

public class Compania {
  private Byte m_CompaniaID;
  private String m_Nombre;

  public Compania ()
  { }

  public Compania (Byte p_CompaniaID, String p_Nombre  )
  {
    m_CompaniaID = p_CompaniaID;
    m_Nombre = p_Nombre;
  }

  public Byte getCompaniaID()
  {
    return this.m_CompaniaID;
  }
  public void setCompaniaID(Byte value)
  {
    this.m_CompaniaID = value;
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
