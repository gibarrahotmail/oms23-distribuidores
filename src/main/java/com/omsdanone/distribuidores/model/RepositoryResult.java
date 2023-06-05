package com.omsdanone.distribuidores.model;

public class RepositoryResult {
  private int Code;
  private String Message;
  private int Affected;
  private Long NewValue;


  public RepositoryResult(int code, String message, int affected, Long newValue) {
    Code = code;
    Message = message;
    Affected = affected;
    NewValue = newValue;
  }
  
  public int getCode() {
    return Code;
  }
  public void setCode(int code) {
    Code = code;
  }
  public String getMessage() {
    return Message;
  }
  public void setMessage(String message) {
    Message = message;
  }
  public int getAffected() {
    return Affected;
  }
  public void setAffected(int affected) {
    Affected = affected;
  }
  public Long getNewValue() {
    return NewValue;
  }
  public void setNewValue(Long newValue) {
    NewValue = newValue;
  }

}
