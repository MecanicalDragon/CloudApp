package net.medrag.amqpsender.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Stanislav Tretyakov
 * 28.06.2020
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(){
        return "index.html";
    }
}
