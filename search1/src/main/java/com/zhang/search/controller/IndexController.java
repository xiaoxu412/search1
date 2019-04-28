package com.zhang.search.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class IndexController {
	/**
     * 数据库搜索首页
     * @return
     * ModelAndView将后台返回的数据传递给View层，同时包含一个要访问的View层的URL地址
     */
    @RequestMapping("/search")
    public ModelAndView init(){
        ModelAndView mav = new ModelAndView("search");
        return mav;
    }

}
