package com.kris.program.webapi.BaiduAPI.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * LocationIp API 返回对象
 *
 * @author Kairou Zeng
 */
public class LocationIP {

    private String address;

    @Data
    static class Content{
        private String address;

        @JsonProperty("address_detail")
        private AddressDetail addressDetail;

    }

    @Data
    static  class AddressDetail{
        private String city;

        @JsonProperty("city_code")
        private String cityCode;

        private String district;

        private String province;

        private String street;

        @JsonProperty("street_number")
        private String streetNumber;
    }
}



