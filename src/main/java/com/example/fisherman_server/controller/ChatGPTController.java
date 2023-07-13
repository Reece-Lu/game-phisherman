package com.example.fisherman_server.controller;


import com.example.fisherman_server.common.Result;
import com.example.fisherman_server.controller.DTO.GPTChatting;
import com.example.fisherman_server.controller.DTO.QuestionGettingDTO;
import com.example.fisherman_server.controller.DTO.SubmitGameSessionDTO;
import com.example.fisherman_server.entity.Question;
import com.example.fisherman_server.service.ChatGPTService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value = "Update user's highest score and create time", notes = "Update the user's highest score and create time based on the provided ID and score")
    @PutMapping("/updateScoreAndTime")
    public Result updateScoreAndTime(@RequestBody SubmitGameSessionDTO submitGameSessionDTO) {
        int id = submitGameSessionDTO.getId();
        int score = submitGameSessionDTO.getScore();

        // Perform the update operation
        Integer re = chatGPTService.submitGameSession(id, score);

        return Result.success(re);

    }


}
