package com.example.fisherman_server.service;

import com.example.fisherman_server.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RankService {

    List<User> getRankBoard();

}