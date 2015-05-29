package com.dashkevich.systemcontrol.dataaccess.dao;

import com.dashkevich.systemcontrol.dataaccess.model.HibernateSystemResource;
import com.dashkevich.systemcontrol.dataaccess.persistence.HibernateUtil;
import com.dashkevich.systemcontrol.systemmonitor.dao.SystemResourceDAO;
import com.dashkevich.systemcontrol.systemmonitor.model.SystemResource;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SystemResourceDAOImpl implements SystemResourceDAO{
    public void addSystemResource(SystemResource sr){
        System.out.println("addSystemResource");
        System.out.println(sr);
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        HibernateSystemResource hsr = new HibernateSystemResource(sr);

        session.save(hsr);
        session.getTransaction().commit();
    }

    public List<SystemResource> listSystemResource(){
        System.out.println("addSystemResource");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();


        session.getTransaction().commit();
        return null;
    }

    public void removeSystemResource(Integer id){
        System.out.println("addSystemResource");
        System.out.println(id);
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        //session.
        session.getTransaction().commit();
    }
}
