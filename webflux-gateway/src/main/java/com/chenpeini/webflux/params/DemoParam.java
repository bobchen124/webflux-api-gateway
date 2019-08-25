package com.chenpeini.webflux.params;

import lombok.Data;

import java.io.Serializable;

/**
 * @Desc:
 * @Author: chenbo
 * @Date: 2019/8/23 09:40
 **/
@Data
public class DemoParam implements Serializable {

    private String name;

    private Integer age;
}
