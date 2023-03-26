package com.yupi.autoreply.api.openai.model;

import lombok.Data;

import java.util.List;

/**
 * 创建补全请求
 * <a href="https://platform.openai.com/docs/api-reference/completions/create">参考文档</a>
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
@Data
public class CreateCompletion3Request {

    /**
     * 模型
     */
    private String model;

    private List<Message> messages;

    private Float temperature;
}
