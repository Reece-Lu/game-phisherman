package com.example.fisherman_server.service.impl;

import com.example.fisherman_server.dao.RankDao;
import com.example.fisherman_server.entity.User;
import com.example.fisherman_server.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankServiceImpl implements RankService {

    @Autowired
    RankDao rankDao;

    public List<User> getRankBoard(){
        return rankDao.getTop10UsersByHighestScore();
    }
}
