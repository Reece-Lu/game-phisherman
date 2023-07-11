package com.example.fisherman_server.controller;


import com.example.fisherman_server.common.Result;
import com.example.fisherman_server.controller.DTO.GPTChatting;
import com.example.fisherman_server.controller.DTO.QuestionGettingDTO;
import com.example.fisherman_server.entity.Question;
import com.example.fisherman_server.service.ChatGPTService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/fisherman/GPT")
@Resource
public class ChatGPTController {

    @Autowired
    ChatGPTService chatGPTService;

    @ApiOperation(value = "single GPT chat",notes = "Input is your question for ChatGPT")
    @PostMapping("/chatting")
    public Result GPTSingleChat(@RequestBody GPTChatting gptChatting){

        List<String> re  = chatGPTService.GPTSingleChatting(gptChatting);

        if(re!=null){
            return Result.success(re);
        }else{
            return Result.error();
        }
    }

    @ApiOperation(value = "get a Question",notes = "Parameter N is the penultimate N question in the database.")
    @PostMapping("/questionGetting")
    public Result QuestionGetting(@RequestBody QuestionGettingDTO questionGettingDTO){

        List<Question> re  = chatGPTService.getNthQuestion(questionGettingDTO.getN());

        if(re!=null){
            return Result.success(re);
        }else{
            return Result.error();
        }
    }

}
