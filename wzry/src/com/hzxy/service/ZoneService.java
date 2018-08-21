package com.hzxy.service;
import java.util.List;
import com.hzxy.dao.ZoneDao;
import com.hzxy.entity.Zone;

/**
 * 版块的业务逻辑处理类
 * @author HZXY
 *
 */
public class ZoneService {
	
	private ZoneDao zoneDao = new ZoneDao();

	
	public List<Zone> getZoneList() {
		//直接调用数据访问类查询数据库
		return zoneDao.getZoneList();
	}

}
