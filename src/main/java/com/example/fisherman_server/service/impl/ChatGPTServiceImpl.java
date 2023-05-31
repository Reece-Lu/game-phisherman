package com.example.fisherman_server.service.impl;

import com.example.fisherman_server.controller.DTO.GPTChatting;
import com.example.fisherman_server.service.ChatGPTService;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatGPTServiceImpl implements ChatGPTService {


    @Override
    public List<String> GPTSingleChatting(GPTChatting gptChatting) {
        String token = "";

        OpenAiService service = new OpenAiService(token);
        CompletionRequest completionRequest = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt(gptChatting.getPrompt())
                .temperature(0.5)
                .maxTokens(2048)
                .topP(1D)
                .frequencyPenalty(0D)
                .presencePenalty(0D)
                .build();

        List<String> choices = new ArrayList<>();

        service.createCompletion(completionRequest).getChoices().forEach(choice -> {
            choices.add(choice.getText());
        });

        return choices;

    }



}