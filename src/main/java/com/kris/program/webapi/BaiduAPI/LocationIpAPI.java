package com.kris.program.webapi.BaiduAPI;

import com.kris.program.webapi.BaiduAPI.config.BaiduAPIConfig;
import com.kris.program.webapi.BaiduAPI.model.LocationIP;
import com.kris.program.webapi.core.exception.SystemException;
import com.kris.program.webapi.core.model.Response;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


/**
 * IP定位
 *
 * @author Kairou Zeng
 */
@AllArgsConstructor
@Component
public class LocationIpAPI {

    private static final String URL = "http://api.map.baidu.com/location/ip?ak=%s&coor=%s";
    private static final String BAIDU_COOR = "bd09ll";

    private final BaiduAPIConfig baiduAPIConfig;

    private LocationIP getLocationByIp(){
        String url = String.format(URL, baiduAPIConfig.getApplicationKey(), BAIDU_COOR);
//        String url = String.format(URL, "kc9o0GlPTCgH5VcCvBVpRPnBYx5TWEZd", BAIDU_COOR);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<LocationIP> response = restTemplate.exchange(url, HttpMethod.GET, null, LocationIP.class);

        if (!Response.SUCCESS_STATUS.equals(response.getBody().getStatus())) {
            throw new SystemException("LocationIp api调用失败！Error Info:" + response.getBody());
        }
        return response.getBody();
    }

    /*public static void main(String[] args) {
        LocationIpAPI.getLocationByIp();
    }*/

}
