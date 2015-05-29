package com.dashkevich.systemcontrol.systemmonitor.service;

import com.dashkevich.systemcontrol.systemmonitor.dao.SystemResourceDAO;
import com.dashkevich.systemcontrol.systemmonitor.model.SystemResource;
import com.sun.management.OperatingSystemMXBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;
import java.util.Date;

@Service
public class MemoryMonitor implements  Runnable {

    OperatingSystemMXBean bean = (OperatingSystemMXBean) ManagementFactory
            .getOperatingSystemMXBean();

    @Autowired
    SystemResourceDAO srDAO;

    public void run()
    {
        for (int i = 0; i < 3 && !Thread.interrupted(); ++i){
            SystemResource sr = this.check();
            srDAO.addSystemResource(sr);
            System.out.println(sr);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public SystemResource check (){
        SystemResource sr = new SystemResource();
        sr.setType("RAM");
        sr.setCheckTime(new Date());
        sr.setFreeSpace(bean.getFreePhysicalMemorySize());
        sr.setFullSpace(bean.getTotalPhysicalMemorySize());
        return sr;
    }
}
