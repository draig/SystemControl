package com.dashkevich.systemrest.controller.rest;

import com.dashkevich.systemcontrol.systemmonitor.model.SystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/memory/")
public class MemoryController {

	@RequestMapping(value = "last", method = RequestMethod.GET)
	public @ResponseBody SystemResource getLastSrJSON() {
        SystemResource sr =new SystemResource();
        sr.setType("RAM");
        sr.setFreeSpace((long)(Math.random()*3072) + 1024);
        sr.setFullSpace(2048*2);
        sr.setCheckTime(new Date());
        return sr;
	}

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<SystemResource> getSrListJSON() {
        List<SystemResource> srList = new ArrayList<SystemResource>();
        long ct = System.currentTimeMillis();
        for(int i = 0 ; i < 20 ; ++i){
            SystemResource sr =new SystemResource();
            sr.setType("RAM");
            sr.setFreeSpace((long)(Math.random()*3072) + 1024);
            sr.setFullSpace(2048*2);
            sr.setCheckTime(new Date(ct - 1000*i));
            srList.add(sr);
        }
        return srList;
    }
}
