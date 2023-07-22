package com.example.inventorymanager.service.impl;

import com.example.inventorymanager.model.PlayList;
import com.example.inventorymanager.repository.PlaylistRepository;
import com.example.inventorymanager.service.PlaylistService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PlaylistServiceImpl implements PlaylistService {

    private final  PlaylistRepository playlistRepository;

    @Override
    public List<PlayList> getPlayLists() {
        return (List<PlayList>) playlistRepository.findAll();
    }

    @Override
    public PlayList getPlayListById(UUID id) {
        return playlistRepository.getById(id);
    }

    @Override
    public PlayList getPlayListByName(String name) {
        return playlistRepository.getByName(name);
    }

    @Override
    public PlayList createPlayList(PlayList playList) {
        return playlistRepository.save(playList);
    }

    @Override
    public PlayList updatePlayList(UUID id, PlayList playList) {
        PlayList toUpdatePlaylist = playlistRepository.getById(id);
        toUpdatePlaylist.setDescription(playList.getDescription());
        toUpdatePlaylist.setName(playList.getName());
        toUpdatePlaylist.setSongs(playList.getSongs());

        return playlistRepository.save(toUpdatePlaylist);
    }

    @Override
    public void deletePlayList(UUID id) {
        playlistRepository.delete(playlistRepository.getById(id));

    }
}
