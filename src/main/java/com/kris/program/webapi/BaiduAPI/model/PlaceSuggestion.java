package com.kris.program.webapi.BaiduAPI.model;

import lombok.Data;
import lombok.ToString;

/**
 * Place Suggestion API 接口返回对象
 *
 * @author Kairou Zeng
 */
@Data
@ToString
public class PlaceSuggestion {

    /**
     * POI名称
     */
    private String name;
    /**
     * POI经纬度坐标
     */
    private Location location;
    /**
     * POI的唯一标示，ID
     */
    private String uid;
    /**
     * 城市
     */
    private String city;
    /**
     * 区县
     */
    private String district;
}
