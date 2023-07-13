package com.example.fisherman_server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameStatus {
    private Integer score;
    private Integer userId;
    private Integer numFish;
    private Integer level;
    private Integer numAnswered;
    private Integer corrects;
    private Integer wrongs;
}
