package com.lagou.pojo;


public class SysRegion {

  private long id;
  private String regionName;
  private String regionCode;
  private long regionLevel;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getRegionName() {
    return regionName;
  }

  public void setRegionName(String regionName) {
    this.regionName = regionName;
  }


  public String getRegionCode() {
    return regionCode;
  }

  public void setRegionCode(String regionCode) {
    this.regionCode = regionCode;
  }


  public long getRegionLevel() {
    return regionLevel;
  }

  public void setRegionLevel(long regionLevel) {
    this.regionLevel = regionLevel;
  }

}
