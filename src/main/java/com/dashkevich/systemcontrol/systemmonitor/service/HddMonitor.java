package com.dashkevich.systemcontrol.systemmonitor.service;

import com.dashkevich.systemcontrol.systemmonitor.model.SystemResource;
import com.sun.management.OperatingSystemMXBean;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.Date;


public class HddMonitor implements Runnable {
    OperatingSystemMXBean bean = (com.sun.management.OperatingSystemMXBean) ManagementFactory
            .getOperatingSystemMXBean();

    public void run()
    {
        while(!Thread.interrupted()){
            for(SystemResource sr : this.check()){
                System.out.println(sr);
            }
            return;
        }
    }

    public ArrayList<SystemResource> check (){
        File[] roots = File.listRoots();
        ArrayList<SystemResource> resources = new ArrayList();
        for (File root : roots) {
            SystemResource sr = new SystemResource();
            sr.setType("HDD");
            sr.setName(root.getAbsolutePath());
            sr.setFullSpace(root.getTotalSpace());
            sr.setFreeSpace( root.getFreeSpace());
            sr.setCheckTime(new Date());
            resources.add(sr);
        }
        return resources;
    }
}
