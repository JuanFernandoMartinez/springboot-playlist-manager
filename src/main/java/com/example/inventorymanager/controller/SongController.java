package com.example.inventorymanager.controller;

import com.example.inventorymanager.api.SongAPI;
import com.example.inventorymanager.dto.SongDTO;
import com.example.inventorymanager.mapper.SongMapper;
import com.example.inventorymanager.service.SongService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class SongController implements SongAPI {

    private final  SongService songService;
    private final  SongMapper songMapper;
    @Override
    public ResponseEntity<List<SongDTO>> getAllSongs() {
        return new ResponseEntity<>(songService.getSongs().stream().map(songMapper::toDTO).toList(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SongDTO> getSongById(UUID id) {
        return new ResponseEntity<>(songMapper.toDTO(songService.getSongById(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SongDTO> getSongByName(String name) {
        return new ResponseEntity<>(songMapper.toDTO(songService.getSongsByName(name)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SongDTO> createSong(SongDTO song) {
        return new ResponseEntity<>(songMapper.toDTO(songService.createSong(songMapper.toEntity(song))), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<SongDTO> updateSong(UUID id, SongDTO song) {
        return new ResponseEntity<>(songMapper.toDTO(songService.updateSong(id,songMapper.toEntity(song))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Boolean> deleteSong(UUID id) {
        songService.deleteSong(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
