package com.example.inventorymanager.mapper;

import com.example.inventorymanager.dto.PlayListDTO;
import com.example.inventorymanager.model.PlayList;

public interface PlayListMapper {
    PlayList toEntity(PlayListDTO playListDTO);
    PlayListDTO toDTO(PlayList playList);
}
