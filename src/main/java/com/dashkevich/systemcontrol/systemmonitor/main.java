package com.dashkevich.systemcontrol.systemmonitor;

import com.dashkevich.systemcontrol.systemmonitor.dao.SystemResourceDAO;
import com.dashkevich.systemcontrol.systemmonitor.service.MemoryMonitor;
import org.springframework.beans.factory.annotation.Autowired;


public class main {

    @Autowired
    public SystemResourceDAO systemResourceDAO;

    public static void main (String [] args){
        main m = new main ();
        m.systemResourceDAO.removeSystemResource(1);
        System.out.println("end");
    }
}