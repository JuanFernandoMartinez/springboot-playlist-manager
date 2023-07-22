package com.example.inventorymanager.mapper.impl;

import com.example.inventorymanager.dto.PlayListDTO;
import com.example.inventorymanager.mapper.PlayListMapper;
import com.example.inventorymanager.mapper.SongMapper;
import com.example.inventorymanager.model.PlayList;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PlayListMapperImpl implements PlayListMapper {
    private  final SongMapper songMapper;

    @Override
    public PlayList toEntity(PlayListDTO playListDTO) {
        return  new PlayList(playListDTO.getId(),playListDTO.getName(),playListDTO.getDescription(),playListDTO.getSongs().stream().map(songMapper::toEntity).toList());
    }

    @Override
    public PlayListDTO toDTO(PlayList playList) {
        return new PlayListDTO(playList.getId(), playList.getName(), playList.getDescription(), playList.getSongs().stream().map(songMapper::toDTO).toList());
    }
}
