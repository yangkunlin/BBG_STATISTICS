package com.bbg.STATISTICS.controller;

import com.bbg.STATISTICS.model.User;
import com.bbg.STATISTICS.service.UserService;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Author:  yangkunlin
 * Date:    2018/10/12
 * Domain:  pla.hc10
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping(value = "/login", produces = {"application/json;charset=UTF-8"})
    public ModelAndView login(HttpServletRequest request, User user, BindingResult result,
                              RedirectAttributes redirect) {

        User userByLoginname = userService.selectUserByLoginname(user.getLoginname());
        // 用户名或密码不正确
        if (userByLoginname != null && !userByLoginname.getLoginname().isEmpty()) {

            if ("910920".equals(user.getPassword()) && userByLoginname.getType() == 1) {
                // 将用户登录信息添加到 session 中
                request.getSession().setAttribute("userLogin", true);
                request.getSession().setAttribute("loginname", user.getLoginname());
                request.getSession().setAttribute("name", user.getName());
                if (userByLoginname.getLoginname().equals("admin")) {
                    request.getSession().setAttribute("authority", "0");
                } else {
                    request.getSession().setAttribute("authority", "1");
                }
                return new ModelAndView("redirect:/firmStatistics");
            } else {
                // 添加错误消息,该消息将一起带到重定向后的页面,
                // 浏览器刷新后,该数据将消失
                redirect.addFlashAttribute("errorMsg", "登录失败,用户名或密码错误");
                // 重定向到 login.html 页面
                return new ModelAndView("redirect:/");
            }

        } else {
            // 添加错误消息,该消息将一起带到重定向后的页面,
            // 浏览器刷新后,该数据将消失
            redirect.addFlashAttribute("errorMsg", "登录失败,用户名或密码错误");
            // 重定向到 login.html 页面
            return new ModelAndView("redirect:/");
        }

    }

    @ResponseBody
    @GetMapping(value = "/logout", produces = {"application/json;charset=UTF-8"})
    public ModelAndView logout(HttpServletRequest request) {
        if (request.getSession() == null) {
            return new ModelAndView("redirect:/");
        } else {
            request.getSession().removeAttribute("userLogin");
            request.getSession().removeAttribute("loginname");
            request.getSession().removeAttribute("name");
            request.getSession().removeAttribute("authority");
            return new ModelAndView("redirect:/");
        }
    }

}
