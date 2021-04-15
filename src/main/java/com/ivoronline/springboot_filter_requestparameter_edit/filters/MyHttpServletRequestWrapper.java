package com.ivoronline.springboot_filter_requestparameter_edit.filters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class MyHttpServletRequestWrapper extends HttpServletRequestWrapper {

  //PARAMETER MAP WITH ORIGINAL AND ADDITIONAL REQUEST PARAMETERS
  Map<String, String[]> extendedParameterMap = new HashMap<>();

  //===============================================================
  // CONSTRUCTOR
  //===============================================================
  public MyHttpServletRequestWrapper(HttpServletRequest request) {
    super(request);

    //CREATE ADDITIONAL REQUEST PARAMETERS
    String[] age = {"20"};

    //ADD ADDITIONAL REQUEST PARAMETERS TO NEW MAP
    extendedParameterMap.put("age", age);

    //ADD EXISTING REQUEST PARAMETERS TO NEW MAP
    extendedParameterMap.putAll(request.getParameterMap());

  }

  //===============================================================
  // GET PARAMETER NAMES
  //===============================================================
  @Override
  public Enumeration<String> getParameterNames() {
    return Collections.enumeration(extendedParameterMap.keySet());
  }

  //===============================================================
  // GET PARAMETER VALUES
  //===============================================================
  @Override
  public String[] getParameterValues(String name) {
    return extendedParameterMap.get(name);
  }

}
