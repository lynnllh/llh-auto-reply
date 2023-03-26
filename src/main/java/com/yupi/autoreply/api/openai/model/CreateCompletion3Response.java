package com.yupi.autoreply.api.openai.model;

import lombok.Data;

import java.util.List;

/**
 * 创建补全响应
 * <a href="https://platform.openai.com/docs/api-reference/completions/create">参考文档</a>
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
@Data
public class CreateCompletion3Response {

    private Integer created;

    private Usage usage;

    private String model;

    private String id;

    /**
     * 回答列表
     */
    private List<ChoicesItem> choices;

    private String object;

    @Data
    public static class ChoicesItem {

        private String finish_reason;

        private Integer index;

        private Message message;
    }

    @Data
    public static class Usage {

        private Integer completion_tokens;

        private Integer prompt_tokens;

        private Integer total_tokens;
    }
}
