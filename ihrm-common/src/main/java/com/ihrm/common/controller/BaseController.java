package com.ihrm.common.controller;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController {
    protected HttpServletRequest request;
    protected HttpServletResponse response;

    @ModelAttribute
    public void setReqAndResp(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    //企业id，(暂时使用1,以后会动态获取)
    public String parseCompanyId() {
        return "1";
    }

    public String parseCompanyName() {
        return "江苏传智播客教育股份有限公司";
    }
}


