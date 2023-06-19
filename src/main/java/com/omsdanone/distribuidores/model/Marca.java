package com.omsdanone.distribuidores.model;

public class Marca {
  private Byte m_MarcaID;
  private String m_Nombre;
  private Byte m_CompaniaID;
  private String m_Codigo;

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

  public Byte getCompaniaID()
  {
    return this.m_CompaniaID;
  }
  public void setCompaniaID(Byte value)
  {
    this.m_CompaniaID = value;
  }

  public String getCodigo()
  {
    return this.m_Codigo;
  }
  public void setCodigo(String value)
  {
    this.m_Codigo = value;
  }

}
