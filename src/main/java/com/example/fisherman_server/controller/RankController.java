package com.example.fisherman_server.controller;

import com.example.fisherman_server.common.Result;
import com.example.fisherman_server.entity.User;
import com.example.fisherman_server.service.RankService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/fisherman/Rank")
@Resource
public class RankController {

    @Autowired
    RankService rankService;

    @ApiOperation(value = "Get Rank Board", notes = "get the latested rankboard")
    @GetMapping("/rankboard")
    public Result updateGPTChat() {
        // Perform the update operation
        List<User> re = rankService.getRankBoard();

        if (re != null ) {
            return Result.success(re);
        } else {
            return Result.error();
        }
    }


}
