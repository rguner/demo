package com.example.demo;

import com.example.demo.model.Book;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RedissonService {

    private final RedissonNodesAutoConfig redissonNodesAutoConfig;

    @PostConstruct
    public void getRedissonConfig() {
        List<RedissonNodesAutoConfig.RedissonNodeConfig> nodesConfig = redissonNodesAutoConfig.getNodesConfig();
        System.out.println(nodesConfig);

    }

}
