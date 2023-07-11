package com.omsdanone.distribuidores.model;

public class PedidoStatus {
  private Byte m_PedidoStatusID;
  private String m_Descripcion;

  public PedidoStatus ()
  { }

  public PedidoStatus (Byte p_PedidoStatusID, String p_Descripcion  )
  {
    m_PedidoStatusID = p_PedidoStatusID;
    m_Descripcion = p_Descripcion;
  }

  public Byte getPedidoStatusID()
  {
    return this.m_PedidoStatusID;
  }
  public void setPedidoStatusID(Byte value)
  {
    this.m_PedidoStatusID = value;
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
