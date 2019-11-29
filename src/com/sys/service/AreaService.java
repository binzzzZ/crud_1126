package com.sys.service;

import com.sys.dao.AreaDao;
import com.sys.entity.Area;

import java.util.List;

/**
 * @author lrbin
 * @version 1.0.0
 * @company
 * @create 2019/11/28 18:05
 * @Description
 */
public class AreaService {
    private AreaDao areaDao = new AreaDao();

    public List<Area> listAll() {
        return areaDao.listAll();
    }

    public List<Area> getCityById(Integer id) {
        return areaDao.getCityById(id);
    }
}
