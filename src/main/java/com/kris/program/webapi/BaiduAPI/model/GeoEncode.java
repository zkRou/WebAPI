package com.kris.program.webapi.BaiduAPI.model;

import lombok.Data;
import lombok.ToString;

/**
 * GeoEncode API返回对象
 *
 * @author Kairou Zeng
 */
@ToString
@Data
public class GeoEncode {

    /**
     * 经纬度坐标
     */
    private Location location;
    /**
     * 位置的附加信息，是否精确查找。1为精确查找，即准确打点；0为不精确，即模糊打点。
     */
    private Integer precise;
    /**
     * 可信度，描述打点准确度
     */
    private Integer confidence;
    /**
     * 地址类型
     */
    private String level;

}
