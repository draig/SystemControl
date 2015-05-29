package com.dashkevich.systemcontrol.systemmonitor.service;

import com.dashkevich.systemcontrol.systemmonitor.dao.SystemResourceDAO;
import com.dashkevich.systemcontrol.systemmonitor.model.SystemResource;
import com.sun.management.OperatingSystemMXBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.Date;

@Service
public class HddMonitor implements Runnable {
    @Autowired
    SystemResourceDAO srDAO;

    public void run()
    {
        for (int i = 0; i < 3 && !Thread.interrupted(); ++i){
            for(SystemResource sr : this.check()){
                srDAO.addSystemResource(sr);
                System.out.println(sr);
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<SystemResource> check (){
        File[] roots = File.listRoots();
        ArrayList<SystemResource> resources = new ArrayList();
        Date checkDate = new Date();
        for (File root : roots) {
            SystemResource sr = new SystemResource();
            sr.setType("HDD");
            sr.setName(root.getAbsolutePath());
            sr.setFullSpace(root.getTotalSpace());
            sr.setFreeSpace( root.getFreeSpace());
            sr.setCheckTime(checkDate);
            resources.add(sr);
        }
        return resources;
    }
}
