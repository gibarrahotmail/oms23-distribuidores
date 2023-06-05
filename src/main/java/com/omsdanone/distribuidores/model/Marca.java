package com.omsdanone.distribuidores.model;

public class Marca {
  private Byte m_MarcaID;
  private String m_Nombre;

  public Marca ()
  { }

  public Marca (Byte p_MarcaID, String p_Nombre  )
  {
    m_MarcaID = p_MarcaID;
    m_Nombre = p_Nombre;
  }

  public Byte getMarcaID()
  {
    return this.m_MarcaID;
  }
  public void setMarcaID(Byte value)
  {
    this.m_MarcaID = value;
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
