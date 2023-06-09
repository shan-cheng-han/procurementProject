package com.hs.bean.user;

import lombok.Data;

import java.util.Date;

/**
 * @author 韩善成
 * @data 2023/6/5 12:02
 */
@Data
public class User {
    private Integer id;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private String password;

    /**
     *
     */
    private Integer status;

    /**
     *
     */
    private String remark;

    /**
     *
     */
    private Integer version;

    /**
     *
     */
    private Date create_time;

    /**
     *
     */
    private String create_man;

    /**
     *
     */
    private Date modify_time;

    /**
     *
     */
    private String modify_man;
}
