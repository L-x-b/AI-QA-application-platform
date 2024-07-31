package com.yolo.aiQuiz.model.dto.question;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionContentDTO implements Serializable {
    private static final long serialVersionUID = -1966175302310200402L;

    /**
     * 题目标题
     */
    private String title;

    /**
     * 题目选项列表
     */
    private List<Option> options;

    /**
     * 题目列表
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Option implements Serializable {

        private String result;
        private int score;
        private String value;
        private String key;
    }


    // Getters and setters
}
