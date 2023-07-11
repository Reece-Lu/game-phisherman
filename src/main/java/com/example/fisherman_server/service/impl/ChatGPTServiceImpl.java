package com.example.fisherman_server.service.impl;

import com.example.fisherman_server.controller.DTO.GPTChatting;
import com.example.fisherman_server.dao.QuestionsDao;
import com.example.fisherman_server.entity.Question;
import com.example.fisherman_server.service.ChatGPTService;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatGPTServiceImpl implements ChatGPTService {


    @Override
    public List<String> GPTSingleChatting(GPTChatting gptChatting) {
        String token = "sk-";

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

    @Autowired
    QuestionsDao questionsDao;

    @Override
    @Scheduled(cron = "0 10 17 * * MON")
    public void GenerateQuestions(){

        for (int i = 0; i < 100; i++) {
            GPTChatting gptChatting = new GPTChatting("Generate questions about network security，Select Answer in A, B, C, D:\\n\\n Question: [question]\\nOption A: [option_a]\\nOption B: [option_b]\\nOption C: [option_c]\\nOption D: [option_d]\\nAnswer: [answer]");

            List<String> que = GPTSingleChatting(gptChatting);

            String generatedQuestion = que.get(0);
            String[] lines = generatedQuestion.split("\n");

            Question question = new Question();
            question.setQuestion(lines[2].substring(10));
            question.setOptionA(lines[3].substring(9));
            question.setOptionB(lines[4].substring(9));
            question.setOptionC(lines[5].substring(9));
            question.setOptionD(lines[6].substring(9));
            question.setAnswer(lines[7].substring(8));

            System.out.println("Question: " + question.getQuestion());
            System.out.println("Option A: " + question.getOptionA());
            System.out.println("Option B: " + question.getOptionB());
            System.out.println("Option C: " + question.getOptionC());
            System.out.println("Option D: " + question.getOptionD());
            System.out.println("Answer: " + question.getAnswer());
            System.out.println();

            int re = questionsDao.insertQuestion(question);

            if (re == 1) {
                System.out.println("Insert Succeed");
            }
        }



    }

    @Override
    public List<Question> getNthQuestion(int n){
        return questionsDao.getNthQuestion(n);

    }



}