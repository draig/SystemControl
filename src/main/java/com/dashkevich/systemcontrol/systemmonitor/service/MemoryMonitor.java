package com.dashkevich.systemcontrol.systemmonitor.service;

import com.dashkevich.systemcontrol.systemmonitor.model.SystemResource;
import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;
import java.util.Date;


public class MemoryMonitor implements  Runnable {

    OperatingSystemMXBean bean = (com.sun.management.OperatingSystemMXBean) ManagementFactory
            .getOperatingSystemMXBean();

    public void run()
    {
        while(!Thread.interrupted()){
            System.out.println(this.check());
            return;
            /*try{
                Thread.sleep(1000);
            }catch(InterruptedException e){}*/
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
