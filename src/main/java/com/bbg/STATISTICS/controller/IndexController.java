package com.bbg.STATISTICS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Author:  yangkunlin
 * Date:    2018/10/11
 * Domain:  pla.hc10
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {

    @GetMapping // 4.3 版本后的新特性
    public ModelAndView toIndex(HttpServletRequest request) {
        // 返回 templates/firmStatistics.html 页面, html 可以省略
        return new ModelAndView("login.html");
    }

    @ResponseBody
    @GetMapping(value = "/firmStatistics", produces = {"application/json;charset=UTF-8"})
    public ModelAndView go2FirmStatistics(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        if (request.getSession().getAttribute("userLogin") != null && request.getSession().getAttribute("userLogin").equals(true)){
            mv.setViewName("firmStatistics.html");
        }else {
            mv.setViewName("login.html");
        }
        return mv;
    }

    @ResponseBody
    @GetMapping(value = "/userInfoStatistics", produces = {"application/json;charset=UTF-8"})
    public ModelAndView go2UserInfoStatistics(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        if (request.getSession().getAttribute("userLogin") != null && request.getSession().getAttribute("userLogin").equals(true)){
            mv.setViewName("userInfoStatistics.html");
        }else {
            mv.setViewName("login.html");
        }
        return mv;
    }

    @ResponseBody
    @GetMapping(value = "/resumeStatistics", produces = {"application/json;charset=UTF-8"})
    public ModelAndView go2ResumeStatistics(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        if (request.getSession().getAttribute("userLogin") != null && request.getSession().getAttribute("userLogin").equals(true)){
            mv.setViewName("resumeStatistics.html");
        }else {
            mv.setViewName("login.html");
        }
        return mv;
    }

    @ResponseBody
    @GetMapping(value = "/sendStatistics", produces = {"application/json;charset=UTF-8"})
    public ModelAndView go2SendStatistics(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        if (request.getSession().getAttribute("userLogin") != null && request.getSession().getAttribute("userLogin").equals(true)){
            mv.setViewName("sendStatistics.html");
        }else {
            mv.setViewName("login.html");
        }
        return mv;
    }

    @ResponseBody
    @GetMapping(value = "/positionStatistics", produces = {"application/json;charset=UTF-8"})
    public ModelAndView go2PosittionStatistics(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        if (request.getSession().getAttribute("userLogin") != null && request.getSession().getAttribute("userLogin").equals(true)){
            mv.setViewName("positionStatistics.html");
        }else {
            mv.setViewName("login.html");
        }
        return mv;
    }

}
