/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kpsolutionsindia.b2c.admin.controller;

import com.kpsolutionsindia.b2c.admin.model.UserInfo;
import com.kpsolutionsindia.b2c.admin.service.UserInfoService;
import com.kpsolutionsindia.b2c.admin.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author deolapar
 */
@Controller
@RequestMapping("check")
public class CheckUserType {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserTypeService userTypeService;

    @RequestMapping("load")
    public ModelAndView load() {
        ModelAndView mv = new ModelAndView();
        return mv;
    }

    @RequestMapping("typecheck")
    public ModelAndView check(UserInfo userInfo) {
        System.out.println("I am in typecheck");
        if (userInfoService.getUser(userInfo.getUsername(), userInfo.getPassword()) != null) {
                System.out.println("111");
            UserInfo user = userInfoService.getUser(userInfo.getUsername(), userInfo.getPassword());
            int userTypeId = user.getUserTypeId();
                System.out.println("2222");
            if (userTypeId == 28) {
                System.out.println("3333");
                ModelAndView mv = new ModelAndView("admin_dashboard.html");
                return mv;
            }
            if (userTypeId == 29) {
                ModelAndView mv = new ModelAndView("user_dashboard.html");
                return mv;
            }
        }
        ModelAndView mv = new ModelAndView("failure.html");
        return mv;
    }

}
