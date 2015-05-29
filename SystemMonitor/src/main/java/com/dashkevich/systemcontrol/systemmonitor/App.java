package com.dashkevich.systemcontrol.systemmonitor;

import com.dashkevich.systemcontrol.systemmonitor.dao.SystemResourceDAO;
import com.dashkevich.systemcontrol.systemmonitor.service.HddMonitor;
import com.dashkevich.systemcontrol.systemmonitor.service.MemoryMonitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App implements Runnable{

    @Override
    public void run() {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config-import.xml");
        HddMonitor hddMonitor = context.getBean(HddMonitor.class);
        MemoryMonitor memoryMonitor = context.getBean(MemoryMonitor.class);
        Thread hddMonitoring = new Thread(hddMonitor);
        Thread memoryMonitoring = new Thread(memoryMonitor);
        hddMonitoring.start();
        memoryMonitoring.start();
        try {
            hddMonitoring.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            memoryMonitoring.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        context.close();
    }
}