package com.yupi.autoreply.answerer;

import com.google.common.collect.Lists;
import com.yupi.autoreply.api.openai.OpenAiApi;
import com.yupi.autoreply.api.openai.model.*;
import com.yupi.autoreply.config.OpenAiConfig;
import com.yupi.autoreply.utils.SpringContextUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class OpenApi3Answerer  implements Answerer {
    private final OpenAiApi openAiApi = SpringContextUtils.getBean(OpenAiApi.class);

    private final OpenAiConfig openAiConfig = SpringContextUtils.getBean(OpenAiConfig.class);

    @Override
    public String doAnswer(String content) {
        CreateCompletion3Request request = new CreateCompletion3Request();
        request.setModel(openAiConfig.getModel());
        request.setTemperature(0.7f);
        Message message = new Message();
        message.setRole("user");
        message.setContent(content);
        request.setMessages(Lists.newArrayList(message));
        CreateCompletion3Response response = openAiApi.createCompletion3(request, openAiConfig.getApiKey());
        List<CreateCompletion3Response.ChoicesItem> choicesItemList = response.getChoices();
        String answer = choicesItemList.stream()
                .map(CreateCompletion3Response.ChoicesItem::getMessage).map(Message::getContent)
                .collect(Collectors.joining());
        log.info("OpenAiAnswerer 回答成功 \n 答案：{}", answer);
        return answer;
    }
}
