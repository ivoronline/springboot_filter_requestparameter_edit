package com.ivoronline.springboot_filter_requestparameter_edit.filters;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class MyFilter extends OncePerRequestFilter {

  @Override
  public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
    throws IOException, ServletException {

    //CREATE REPLACEMENT REQUEST
    HttpServletRequest myHttpServletRequestWrapper = new MyHttpServletRequestWrapper(request);

    //FORWARD REPLACEMENT REQUEST (With additional Request Parameters)
    chain.doFilter(myHttpServletRequestWrapper, response);

  }

}
