package com.dashkevich.systemcontrol.dataaccess;

import com.dashkevich.systemcontrol.dataaccess.model.HibernateSystemResource;
import com.dashkevich.systemcontrol.dataaccess.persistence.HibernateUtil;
import com.dashkevich.systemcontrol.systemmonitor.service.MemoryMonitor;
import org.hibernate.Session;
import java.util.Date;

public class App
{
    public static void main (String [] args){
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        HibernateSystemResource hsr = new HibernateSystemResource();

        MemoryMonitor mm = new MemoryMonitor();
        hsr.setType("RAM");
        hsr.setFullSpace(4000);
        hsr.setFreeSpace(1500);
        hsr.setCheckTime(new Date());
        System.out.println(hsr);

        session.save(hsr);
        session.getTransaction().commit();
    }
}