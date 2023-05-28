package com.example.fisherman_server.service;

import com.example.fisherman_server.controller.DTO.GPTChatting;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChatGPTService {

    List<String> GPTSingleChatting(GPTChatting gptChatting);

}
