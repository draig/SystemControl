package com.dashkevich.systemcontrol.systemmonitor.dao;


import com.dashkevich.systemcontrol.systemmonitor.model.SystemResource;

import java.util.List;

public interface SystemResourceDAO {

    public void addSystemResource(SystemResource sr);

    public List<SystemResource> listSystemResource();

    public void removeSystemResource(Integer id);
}
