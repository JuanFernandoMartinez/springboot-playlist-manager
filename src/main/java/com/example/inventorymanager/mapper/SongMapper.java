package com.example.inventorymanager.mapper;

import com.example.inventorymanager.dto.SongDTO;
import com.example.inventorymanager.model.Song;



public interface SongMapper {
    Song toEntity(SongDTO songDTO);
    SongDTO toDTO(Song song);
}
