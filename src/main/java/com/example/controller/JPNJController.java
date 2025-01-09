package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jpnj")
public class JPNJController {

 
    @RequestMapping("/dashboard")
    public String jpnjDashboardPage() {
        return "jpnj_dashboard";
    }

    @RequestMapping("/statistics")
    public String statisticsPage() {
        return "jpnj_statistics";
    }

    @RequestMapping("/monitorTVPSSResource")
    public String monitorTVPSSResourcePage() {
        return "monitor_tvpss_resource"; // Returning JSP name
    }
}
