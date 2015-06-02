package com.dashkevich.fullrestapi.web;


import com.dashkevich.fullrestapi.service.SystemResourceService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.util.Date;

@Controller
@RequestMapping(value = "/memory")
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemoryController {

    /*@Autowired
    private SystemResourceService contactService;*/

    @RequestMapping(value = "last", method = RequestMethod.GET)
    public @ResponseBody SystemResource getShopInJSON(@PathVariable String name) {


        SystemResource sr = new SystemResource();
        sr.setType("RAM");

        return sr;

    }

    @RequestMapping("/delete/{memoryId}")
    public String deleteContact(@PathVariable("memoryId") Integer contactId) {

        //contactService.removeContact(contactId);

        return "redirect:/index";
    }

}

class SystemResource implements Serializable {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
