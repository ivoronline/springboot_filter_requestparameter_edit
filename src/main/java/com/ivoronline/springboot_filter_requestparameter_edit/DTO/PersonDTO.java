package com.ivoronline.springboot_filter_requestparameter_edit.DTO;

public class PersonDTO {

  //PROPERTIES
  public String name;
  public Float  height;        //EDIT EXISTING REQUEST PARAMETER

  //SETTERS (Used for Deserialization)
  public void setName  (String name  ) { this.name   = name;   }
  public void setHeight(Float  height) { this.height = height; }

}
