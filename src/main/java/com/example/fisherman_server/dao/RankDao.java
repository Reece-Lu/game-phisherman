package com.example.fisherman_server.dao;

import com.example.fisherman_server.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RankDao {

    List<User> getTop10UsersByHighestScore();

}
