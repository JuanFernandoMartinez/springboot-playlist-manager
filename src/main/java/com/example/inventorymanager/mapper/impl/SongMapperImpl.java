package com.example.inventorymanager.mapper.impl;

import com.example.inventorymanager.dto.SongDTO;
import com.example.inventorymanager.mapper.SongMapper;
import com.example.inventorymanager.model.Song;

public class SongMapperImpl implements SongMapper {
    @Override
    public Song toEntity(SongDTO songDTO) {
        return new Song(songDTO.getId(),songDTO.getTitle(), songDTO.getUrl());
    }

    @Override
    public SongDTO toDTO(Song song) {
        return new SongDTO(song.getId(),song.getTitle(), song.getUrl());
    }
}
