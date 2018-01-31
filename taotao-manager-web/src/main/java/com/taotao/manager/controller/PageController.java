package com.taotao.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/page")
public class PageController {

    /**
     * 通用页面跳转
     * @param pagename
     * @return
     */
    @RequestMapping(value = "/{pagename}")
    public String page(@PathVariable(value = "pagename")String pagename){
        return pagename;
    }
}
