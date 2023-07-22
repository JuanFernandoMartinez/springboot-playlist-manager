package com.example.inventorymanager.api;

import com.example.inventorymanager.dto.SongDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/songs")
public interface SongAPI {
    @GetMapping
    ResponseEntity<List<SongDTO>> getAllSongs();

    @GetMapping("/id/{id}")
    ResponseEntity<SongDTO> getSongById(@PathVariable UUID id);

    @GetMapping("/name/{name}")
    ResponseEntity<SongDTO> getSongByName(@PathVariable String name);

    @PostMapping
    ResponseEntity<SongDTO> createSong(@RequestBody SongDTO song);

    @PutMapping("/{id}")
    ResponseEntity<SongDTO> updateSong(@PathVariable UUID id, @RequestBody SongDTO song);

    @DeleteMapping("/{id}")
    ResponseEntity<Boolean> deleteSong(@PathVariable UUID id);

}
