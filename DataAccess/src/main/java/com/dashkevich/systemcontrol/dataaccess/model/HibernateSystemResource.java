package com.dashkevich.systemcontrol.dataaccess.model;

import com.dashkevich.systemcontrol.systemmonitor.model.SystemResource;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "system_data", catalog = "system_monitoring")
public class HibernateSystemResource extends SystemResource implements Serializable {

    public HibernateSystemResource (SystemResource sr){
        super.setName(sr.getName());
        super.setType(sr.getType());
        super.setFullSpace(sr.getFullSpace());
        super.setFreeSpace(sr.getFreeSpace());
        super.setCheckTime(sr.getCheckTime());
    }

    public HibernateSystemResource (){
        super();
    }

    Integer id;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "sd_id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "type")
    @Override
    public String getType() {
        return super.getType();
    }

    @Column(name = "name")
    public String getName() {
        return super.getName();
    }

    @Column(name = "total_space")
    public long getFullSpace() {
        return super.getFullSpace();
    }

    @Column(name = "free_space")
    public long getFreeSpace() {
        return super.getFreeSpace();
    }

    @Column(name = "check_time")
    public Date getCheckTime() {
        return super.getCheckTime();
    }

    @Override
    public String toString() {
        return "type:" + this.getType()
                + "\nname:" + this.getName()
                + "\nfree space:" + this.getFreeSpace()
                + "\nfull space:" + this.getFullSpace()
                + "\ncheck time:" + this.getCheckTime();

    }

}
