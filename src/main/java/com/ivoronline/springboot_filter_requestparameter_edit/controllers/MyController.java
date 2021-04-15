package com.ivoronline.springboot_filter_requestparameter_edit.controllers;

import com.ivoronline.springboot_filter_requestparameter_edit.DTO.PersonDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

  @ResponseBody
  @RequestMapping("/Hello")
  public String hello(PersonDTO personDTO) {
    return personDTO.name + " is " + personDTO.height + " meters tall";
  }

}
