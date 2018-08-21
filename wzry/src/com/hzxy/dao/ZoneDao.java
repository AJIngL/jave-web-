package com.hzxy.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hzxy.entity.Zone;
import com.hzxy.tool.MyDBUtils;

/**
 * 版块表的数据访问类
 * @author HZXY
 *
 */
public class ZoneDao {

	/**
	 * 获取版块列表
	 * @return
	 */
	public List<Zone> getZoneList() {
		try {
			String sql = "select * from tb_zone";
			return MyDBUtils.runner.query(sql, new BeanListHandler<Zone>(Zone.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
