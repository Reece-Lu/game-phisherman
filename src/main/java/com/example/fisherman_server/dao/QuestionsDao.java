package com.example.fisherman_server.dao;

import com.example.fisherman_server.entity.Question;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionsDao {
//  Insert a question into the questions table
    Integer insertQuestion(Question question);

//   Retrieve the content of the nth question
    List<Question> getNthQuestion(int n);

}
