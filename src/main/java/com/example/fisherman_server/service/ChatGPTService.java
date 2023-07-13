package com.example.fisherman_server.service;

import com.example.fisherman_server.controller.DTO.GPTChatting;
import com.example.fisherman_server.controller.DTO.SubmitGameSessionDTO;
import com.example.fisherman_server.entity.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChatGPTService {

    List<String> GPTSingleChatting(GPTChatting gptChatting);

    void GenerateQuestions();

    List<Question> getNthQuestion(int n);

    Integer submitGameSession(int id, int score);

}
