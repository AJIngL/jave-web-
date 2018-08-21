package com.hzxy.entity;

import java.io.Serializable;

/**
 * 论坛版块表
 * @author HZXY
 *
 */
public class Zone implements Serializable{
	
	private int zoneId;
	private String zoneName;
	private int isDef;
	public int getZoneId() {
		return zoneId;
	}
	public void setZoneId(int zoneId) {
		this.zoneId = zoneId;
	}
	public String getZoneName() {
		return zoneName;
	}
	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}
	public int getIsDef() {
		return isDef;
	}
	public void setIsDef(int isDef) {
		this.isDef = isDef;
	}
	public Zone(int zoneId, String zoneName, int isDef) {
		super();
		this.zoneId = zoneId;
		this.zoneName = zoneName;
		this.isDef = isDef;
	}
	public Zone(String zoneName, int isDef) {
		super();
		this.zoneName = zoneName;
		this.isDef = isDef;
	}
	@Override
	public String toString() {
		return "Zone [zoneId=" + zoneId + ", zoneName=" + zoneName + ", isDef=" + isDef + "]";
	}
	public Zone() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}

