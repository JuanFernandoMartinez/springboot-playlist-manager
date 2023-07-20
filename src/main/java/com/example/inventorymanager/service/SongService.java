package com.example.inventorymanager.service;

import com.example.inventorymanager.model.Song;

import java.util.List;
import java.util.UUID;

public interface SongService {
    List<Song> getSongs();
    Song getSongById(UUID id);
    Song getSongsByName(String name);
    Song createSong(Song song );
    Song updateSong(UUID id, Song song);
    void deleteSong(UUID id);

}
