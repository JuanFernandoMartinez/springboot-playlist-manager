package com.example.inventorymanager;

import com.example.inventorymanager.mapper.SongMapper;
import com.example.inventorymanager.mapper.impl.SongMapperImpl;
import com.example.inventorymanager.repository.SongRepository;
import com.example.inventorymanager.service.SongService;
import com.example.inventorymanager.service.impl.SongServiceImpl;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class Config {

    @Bean
    SongMapper songMapper(){
        return new SongMapperImpl();
    }


}
