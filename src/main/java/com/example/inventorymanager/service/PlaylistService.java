package com.example.inventorymanager.service;

import com.example.inventorymanager.model.PlayList;

import java.util.List;
import java.util.UUID;

public interface PlaylistService {
    List<PlayList> getPlayLists();
    PlayList getPlayListById(UUID id);
    PlayList getPlayListByName(String name);
    PlayList createPlayList(PlayList playList);
    PlayList updatePlayList(UUID id, PlayList playList);
    void deletePlayList(UUID id);
}
