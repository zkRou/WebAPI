package com.kris.program.webapi.core.model;

import lombok.Data;
import lombok.ToString;

/**
 * 接口返回
 *
 * @author Kairou Zeng
 */
@Data
@ToString
public class Response<T> {

    /**
     * 接口返回成功状态值
     */
    public static final Integer SUCCESS_STATUS = 0;

    /**
     * 接口返回结果状态值
     */
    private Integer status;
    /**
     * 接口返回结果
     */
    private T result;
}
