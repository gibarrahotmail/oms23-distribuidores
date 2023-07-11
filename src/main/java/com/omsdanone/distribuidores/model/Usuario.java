package com.omsdanone.distribuidores.model;

import java.util.Optional;

public class Usuario {
    private Short m_UsuarioID;
    private String m_Apellidos;
    private String m_Nombre;
    private String m_Cuenta;
    private String m_Contrasenia;
    private boolean m_Activo;
    private Byte m_PerfilID;
    private Optional<Byte> m_SectorID;
    private Optional<Short> m_CadenaComercialId;
    private Optional<Integer> m_TiendaId;
    private Integer m_Permisos;
    private Optional<Short> m_JefeID;
    private String m_Perfil;

    public Usuario ()
    { }

    public Usuario (Short p_UsuarioID, String p_Apellidos, String p_Nombre, String p_Cuenta, String p_Contrasenia, 
      boolean p_Activo, Byte p_PerfilID, Optional<Byte> p_SectorID, Optional<Short> p_CadenaComercialId, 
      Optional<Integer> p_TiendaId, Integer p_Permisos, Optional<Short> p_JefeID)
  {
    m_UsuarioID = p_UsuarioID;
    m_Apellidos = p_Apellidos;
    m_Nombre = p_Nombre;
    m_Cuenta = p_Cuenta;
    m_Contrasenia = p_Contrasenia;
    m_Activo = p_Activo;
    m_PerfilID = p_PerfilID;
    m_SectorID = p_SectorID;
    m_CadenaComercialId = p_CadenaComercialId;
    m_TiendaId = p_TiendaId;
    m_Permisos = p_Permisos;
    m_JefeID = p_JefeID;
  }

  public Short getUsuarioID()
  {
    return this.m_UsuarioID;
  }
  public void setUsuarioID(Short value)
  {
    this.m_UsuarioID = value;
  }

  public String getApellidos()
  {
    return this.m_Apellidos;
  }
  public void setApellidos(String value)
  {
    this.m_Apellidos = value;
  }

  public String getNombre()
  {
    return this.m_Nombre;
  }
  public void setNombre(String value)
  {
    this.m_Nombre = value;
  }

  public String getCuenta()
  {
    return this.m_Cuenta;
  }
  public void setCuenta(String value)
  {
    this.m_Cuenta = value;
  }

  public String getContrasenia()
  {
    return this.m_Contrasenia;
  }
  public void setContrasenia(String value)
  {
    this.m_Contrasenia = value;
  }

  public boolean getActivo()
  {
    return this.m_Activo;
  }
  public void setActivo(boolean value)
  {
    this.m_Activo = value;
  }

  public Byte getPerfilID()
  {
    return this.m_PerfilID;
  }
  public void setPerfilID(Byte value)
  {
    this.m_PerfilID = value;
  }

  public Optional<Byte> getSectorID()
  {
    return this.m_SectorID;
  }
  public void setSectorID(Optional<Byte> value)
  {
    this.m_SectorID = value;
  }

  public Optional<Short> getCadenaComercialId()
  {
    return this.m_CadenaComercialId;
  }
  public void setCadenaComercialId(Optional<Short> value)
  {
    this.m_CadenaComercialId = value;
  }

  public Optional<Integer> getTiendaId()
  {
    return this.m_TiendaId;
  }
  public void setTiendaId(Optional<Integer> value)
  {
    this.m_TiendaId = value;
  }

  public Integer getPermisos()
  {
    return this.m_Permisos;
  }
  public void setPermisos(Integer value)
  {
    this.m_Permisos = value;
  }

  public Optional<Short> getJefeID()
  {
    return this.m_JefeID;
  }
  public void setJefeID(Optional<Short> value)
  {
    this.m_JefeID = value;
  }

  public String getPerfil()
  {
    return this.m_Perfil;
  }
  public void setPerfil(String value)
  {
    this.m_Perfil = value;
  }  
}
