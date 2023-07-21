package com.example.inventorymanager.service.impl;

import com.example.inventorymanager.model.Song;
import com.example.inventorymanager.repository.SongRepository;
import com.example.inventorymanager.service.SongService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;

    @Override
    public List<Song> getSongs() {
        return songRepository.findAll();
    }

    @Override
    public Song getSongById(UUID id) {
        return songRepository.getById(id);
    }

    @Override
    public Song getSongsByName(String name) {
        return songRepository.getByTitle(name);
    }

    @Override
    public Song createSong(Song song) {
        return songRepository.save(song);
    }

    @Override
    public Song updateSong(UUID id, Song song) {
        Song toUpdateSong = songRepository.getById(id);
        toUpdateSong.setUrl(song.getUrl());
        toUpdateSong.setTitle(song.getTitle());
        return songRepository.save(toUpdateSong);
    }

    @Override
    public void deleteSong(UUID id) {
        songRepository.delete(songRepository.getById(id));
    }
}
