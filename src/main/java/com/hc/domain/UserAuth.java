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
    * 用户权限表
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "shiro_user_auth")
public class UserAuth implements Serializable {
    private static final long serialVersionUID = 678219035532127921L;
    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户编号
     */
    @TableField(value = "user_id")
    private Integer userId;

    /**
     * 权限编号
     */
    @TableField(value = "auth_id")
    private Integer authId;
}