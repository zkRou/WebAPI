package com.kris.program.webapi.BaiduAPI.model;

import lombok.Data;

@Data
public class Location {

    /**
     * 经度
     */
    private Double lng;

    /**
     * 纬度
     */
    private Double lat;
}