package com.sys.dao;

import com.sys.entity.Area;
import com.sys.utils.JdbcTemplateUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author lrbin
 * @version 1.0.0
 * @company
 * @create 2019/11/28 17:59
 * @Description
 */
public class AreaDao {
    private JdbcTemplate template = new JdbcTemplate(JdbcTemplateUtil.getDataSource());

    public List<Area> listAll() {
        String sql = "select * from area where type =1";
        return template.query(sql, new BeanPropertyRowMapper<>(Area.class));
    }

    public List<Area> getCityById(Integer id) {
        String sql = "select * from area where p_id = ?";
        return template.query(sql, new BeanPropertyRowMapper<>(Area.class), id);
    }
}
