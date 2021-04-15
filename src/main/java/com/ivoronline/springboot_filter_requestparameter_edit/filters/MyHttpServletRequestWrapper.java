package com.ivoronline.springboot_filter_requestparameter_edit.filters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class MyHttpServletRequestWrapper extends HttpServletRequestWrapper {

  //PARAMETER MAP WITH ORIGINAL AND EDITED REQUEST PARAMETERS
  Map<String, String[]> extendedParameterMap = new HashMap<>();

  //===============================================================
  // CONSTRUCTOR
  //===============================================================
  public MyHttpServletRequestWrapper(HttpServletRequest request) {
    super(request);

    //GET VALUE (OF EXISTING HTTP REQUEST PARAMETER)
    String heightChanged = request.getParameterMap().get("height")[0];

    //EDIT VALUE
    heightChanged = heightChanged.replace(",", ".");  //1,67 to 1.67

    //CREATE REPLACEMENT REQUEST PARAMETER
    String[] height = {heightChanged};

    //ADD EXISTING REQUEST PARAMETERS TO NEW MAP
    extendedParameterMap.putAll(request.getParameterMap());

    //ADD CHANGED REQUEST PARAMETER TO NEW MAP (overriding exiting with the same key)
    extendedParameterMap.put("height", height);

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
