package com.kris.program.webapi.BaiduAPI;

import com.kris.program.webapi.BaiduAPI.config.BaiduAPIConfig;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * IP定位
 *
 * @author Kairou Zeng
 */
@AllArgsConstructor
@Component
public class LocationIpAPI {

    private static final String URL = "http://api.map.baidu.com/location/ip?ak=%s&coor=%s";

    private final BaiduAPIConfig baiduAPIConfig;

}
