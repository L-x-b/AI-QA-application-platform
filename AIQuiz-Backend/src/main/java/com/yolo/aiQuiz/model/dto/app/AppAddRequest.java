package com.yolo.aiQuiz.model.dto.app;

import lombok.Data;

import java.io.Serializable;

/**
 * 创建应用请求
 *
 */
@Data
public class AppAddRequest implements Serializable {


    /**
     * 应用名
     */
    private String appName;

    /**
     * 应用描述
     */
    private String appDesc;

    /**
     * 应用图标
     */
    private String appIcon;

    /**
     * 应用类型（0-得分类，1-测评类）
     */
    private Integer appType;

    /**
     * 评分策略（0-自定义，1-AI）
     */
    private Integer scoringStrategy;

    /**
     * 审核状态：0-待审核, 1-通过, 2-拒绝
     */
    private Integer reviewStatus;


    private static final long serialVersionUID = -2956280258974915717L;
}