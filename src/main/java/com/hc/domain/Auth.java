package com.hc.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 权限表
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "shiro_auth")
public class Auth implements Serializable {
    private static final long serialVersionUID = 4734361299771355303L;
    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 权限标题
     */
    @TableField(value = "name")
    private String name;

    /**
     * 权限代码
     */
    @TableField(value = "code")
    private String code;

    /**
     * 权限所能访问资源的路径
     */
    @TableField(value = "url")
    private String url;
}