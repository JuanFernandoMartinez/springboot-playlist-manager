package com.example.inventorymanager.service;

import com.example.inventorymanager.model.Song;
import com.example.inventorymanager.repository.SongRepository;
import com.example.inventorymanager.service.impl.SongServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.UUID;



public class SongServiceTest {


    private SongService toTestSongService;
    private SongRepository songRepository;
    @BeforeEach
    void setupScenery(){
        songRepository = Mockito.mock(SongRepository.class);
        toTestSongService = new SongServiceImpl(songRepository);
    }

    @Test
    void testGetSongs(){
        toTestSongService.getSongs();
        Mockito.verify(songRepository, Mockito.times(1)).findAll();
    }

    @Test
    void testGetSongById(){
        UUID idToSearch = UUID.randomUUID();
        toTestSongService.getSongById(idToSearch);
        Mockito.verify(songRepository, Mockito.times(1)).getById(idToSearch);
    }

    void testGetSongByName(){
        String titleToSearch = "The moon";
        toTestSongService.getSongsByName(titleToSearch);
        Mockito.verify(songRepository, Mockito.times(1)).getByTitle(titleToSearch);
    }

    @Test
    void testCreateSong(){
        Song toSaveSong = new Song(UUID.randomUUID(), "The Moon","Welcome to the jungle");
        toTestSongService.createSong(toSaveSong);
        Mockito.verify(songRepository,Mockito.times(1)).save(toSaveSong);
    }



    @Test
    void testDeleteSong(){
        UUID toDeleteId = UUID.randomUUID();
        toTestSongService.deleteSong(toDeleteId);
        Mockito.verify(songRepository,Mockito.times(1)).delete(Mockito.any());
    }


}
