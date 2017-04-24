package com.kris.program.webapi.BaiduAPI;


import com.kris.program.webapi.BaiduAPI.config.BaiduAPIConfig;
import com.kris.program.webapi.BaiduAPI.model.PlaceSuggestion;
import com.kris.program.webapi.core.exception.SystemException;
import com.kris.program.webapi.core.model.Response;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 地址提示
 *
 * @author Kairou Zeng
 */
@AllArgsConstructor
public class PlaceSuggestionAPI {

    private static final String URL = "http://api.map.baidu.com/place/v2/suggestion?city_limit=true&output=json&ak=%s&query=%s&region=%s";

    private final BaiduAPIConfig baiduAPIConfig;

    public List<PlaceSuggestion> getPlaceSuggestion(String query, String region){
        String url = String.format(URL, baiduAPIConfig.getApplicationKey(), query, region);
//        String url = String.format(URL, "kc9o0GlPTCgH5VcCvBVpRPnBYx5TWEZd", query, region);

        RestTemplate restTemplate = new RestTemplate();

        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.ALL));
//        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
        restTemplate.setMessageConverters(Collections.singletonList(mappingJackson2HttpMessageConverter));

        ResponseEntity<Response<List<PlaceSuggestion>>> response = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<Response<List<PlaceSuggestion>>>() {});

        if (!Response.SUCCESS_STATUS.equals(response.getBody().getStatus())) {
            throw new SystemException("PlaceSuggestion api调用失败！Error Info:" + response.getBody());
        }
        return response.getBody().getResult();
    }

   /* public static void main(String[] args) {
        List<PlaceSuggestion> list = PlaceSuggestionAPI.getPlaceSuggestion("天安门","北京市");
        list.forEach(placeSuggestion -> {
            System.out.println(placeSuggestion);
        });
    }*/
}
