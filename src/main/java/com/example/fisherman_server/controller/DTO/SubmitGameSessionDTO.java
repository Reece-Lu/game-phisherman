package com.example.fisherman_server.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubmitGameSessionDTO {
    private int id;
    private int score;
}
