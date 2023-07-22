package com.example.inventorymanager.controller;

import com.example.inventorymanager.api.PlayListAPI;
import com.example.inventorymanager.dto.PlayListDTO;
import com.example.inventorymanager.dto.SongDTO;
import com.example.inventorymanager.mapper.PlayListMapper;
import com.example.inventorymanager.mapper.SongMapper;
import com.example.inventorymanager.service.PlaylistService;
import com.example.inventorymanager.service.SongService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class PlayListController implements PlayListAPI {

    private final PlaylistService playlistService;
    private final PlayListMapper playListMapper;
    private final SongService songService;
    private final SongMapper songMapper;


    @Override
    public ResponseEntity<List<PlayListDTO>> getPlaylists() {
        return new ResponseEntity<>(playlistService.getPlayLists().stream().map(playListMapper::toDTO).toList(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PlayListDTO> getPlayListById(UUID id) {
        return new ResponseEntity<>(playListMapper.toDTO(playlistService.getPlayListById(id)),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PlayListDTO> getPlayListByName(String name) {
        return new ResponseEntity<>(playListMapper.toDTO(playlistService.getPlayListByName(name)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PlayListDTO> createPlayList(PlayListDTO playList) {
        System.out.println(playList);
        List<SongDTO> songs =  playList.getSongs().stream().map(x-> songService.createSong(songMapper.toEntity(x))).toList().stream().map(songMapper::toDTO).toList();
        playList.setSongs(songs);
        return new ResponseEntity<>(playListMapper.toDTO(playlistService.createPlayList(playListMapper.toEntity(playList))), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<PlayListDTO> updatePlayList(UUID id, PlayListDTO playList) {
        return new ResponseEntity<>(playListMapper.toDTO(playlistService.updatePlayList(id, playListMapper.toEntity(playList))), HttpStatus.OK);
    }

    @Override
    public void deletePlayList(UUID id) {
        playlistService.deletePlayList(id);
    }
}
