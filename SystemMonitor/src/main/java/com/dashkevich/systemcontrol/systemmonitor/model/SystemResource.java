package com.dashkevich.systemcontrol.systemmonitor.model;
import java.util.Date;


public class SystemResource {

    private String type;

    private String name;

    private long fullSpace = 0 ;

    private long freeSpace = 0 ;

    Date checkTime;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getFullSpace() {
        return fullSpace;
    }

    public void setFullSpace(long fullSpace) {
        this.fullSpace = fullSpace;
    }

    public long getFreeSpace() {
        return freeSpace;
    }

    public void setFreeSpace(long freeSpace) {
        this.freeSpace = freeSpace;
    }

    public long usageSpace() {
        return fullSpace - freeSpace;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
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
