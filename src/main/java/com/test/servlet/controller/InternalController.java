package com.test.servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface InternalController {

    void  showAll(HttpServletRequest request, HttpServletResponse response);
}
