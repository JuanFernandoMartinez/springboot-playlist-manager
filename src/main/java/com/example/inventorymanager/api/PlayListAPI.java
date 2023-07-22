package com.example.inventorymanager.api;

import com.example.inventorymanager.dto.PlayListDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/playlist")
public interface PlayListAPI {
    @GetMapping()
    ResponseEntity<List<PlayListDTO>> getPlaylists();

    @GetMapping("/id/{id}")
    ResponseEntity<PlayListDTO> getPlayListById( @PathVariable UUID id);

    @GetMapping("/name/{name}")
    ResponseEntity<PlayListDTO> getPlayListByName(@PathVariable String name);

    @PostMapping
    ResponseEntity<PlayListDTO> createPlayList(@RequestBody PlayListDTO playList);

    @PutMapping("/{id}")
    ResponseEntity<PlayListDTO> updatePlayList( @PathVariable UUID id, @RequestBody PlayListDTO playList);

    @DeleteMapping("/{id}")
    void deletePlayList(@PathVariable UUID id);
}
