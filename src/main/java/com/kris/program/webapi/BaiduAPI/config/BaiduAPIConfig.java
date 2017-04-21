package com.kris.program.webapi.BaiduAPI.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 百度API 配置信息
 *
 * @author Kairou Zeng
 */
@Configuration
@ConfigurationProperties("baiduApi")
@Data
public class BaiduAPIConfig {

    private String applicationKey;

}
