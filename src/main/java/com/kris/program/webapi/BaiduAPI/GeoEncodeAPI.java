package com.kris.program.webapi.BaiduAPI;


import com.kris.program.webapi.BaiduAPI.config.BaiduAPIConfig;
import com.kris.program.webapi.BaiduAPI.model.GeoEncode;
import com.kris.program.webapi.core.exception.SystemException;
import com.kris.program.webapi.core.model.Response;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

/**
 * 地址转经纬度
 *
 * @author Kairou Zeng
 */
@AllArgsConstructor
@Component
public class GeoEncodeAPI {

    private static final String URL = "http://api.map.baidu.com/geocoder/v2/?output=json&ak=%s&address=%s";

    private final BaiduAPIConfig baiduAPIConfig;

    public GeoEncode geoEncoding(String address) {

        String url = String.format(URL, baiduAPIConfig.getApplicationKey(), address);
//        String url = String.format(URL, "kc9o0GlPTCgH5VcCvBVpRPnBYx5TWEZd", address);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(Collections.singletonList(new MappingJackson2HttpMessageConverter()));

        restTemplate.getInterceptors().add((request, body, execution) -> {
            ClientHttpResponse response = execution.execute(request, body);
            response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
            return response;
        });

        ResponseEntity<Response<GeoEncode>> response =
                restTemplate.exchange(url, HttpMethod.GET, null,
                        new ParameterizedTypeReference<Response<GeoEncode>>() {
                        });
        if (!Response.SUCCESS_STATUS.equals(response.getBody().getStatus())) {
            throw new SystemException("GeoEncode api调用失败！Error Info:" + response.getBody());
        }
        return response.getBody().getResult();
    }

    /*public static void main(String[] args) {
        System.out.println(GeoEncodeAPI.geoEncoding("北京市海淀区上地十街10号"));
    }*/
}
