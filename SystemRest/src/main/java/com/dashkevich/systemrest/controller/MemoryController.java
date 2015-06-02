package com.dashkevich.systemrest.controller;

import com.mkyong.common.model.Shop;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;

@Controller
@RequestMapping("/memory/")
public class MemoryController {

	@RequestMapping(value = "last", method = RequestMethod.GET)
	public @ResponseBody SystemResource getShopInJSON() {

        SystemResource sr = new SystemResource();
        sr.setType("RAM");

        return sr;

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
