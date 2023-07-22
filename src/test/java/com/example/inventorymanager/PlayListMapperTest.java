package com.example.inventorymanager;

import com.example.inventorymanager.dto.PlayListDTO;
import com.example.inventorymanager.dto.SongDTO;
import com.example.inventorymanager.mapper.PlayListMapper;
import com.example.inventorymanager.mapper.impl.PlayListMapperImpl;
import com.example.inventorymanager.mapper.impl.SongMapperImpl;
import com.example.inventorymanager.model.PlayList;
import com.example.inventorymanager.model.Song;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PlayListMapperTest {
    private List<Song> theSongs;
    private List<SongDTO> theSongsDTO;
    private final PlayListMapper playListMapper = new PlayListMapperImpl(new SongMapperImpl());

    void setup1(){
        Song[] songs = {new Song(UUID.randomUUID(), "the Moon", "google.com"),
                new Song(UUID.randomUUID(), "the Son", "Youtube.com")
        };
        theSongs = List.of(songs);
    }

    void setup2(){
        SongDTO[] songs = {new SongDTO(UUID.randomUUID(), "the Moon", "google.com"),
                            new SongDTO(UUID.randomUUID(), "the Son", "Youtube.com")
        };
        theSongsDTO = List.of(songs);
    }

    @Test
    void testToDTO(){
        setup1();
        PlayList playList = new PlayList(UUID.randomUUID(), "The moonlight", "google.com", theSongs);
        PlayListDTO playListDTO = playListMapper.toDTO(playList);
        assertEquals(playList.getName(), playListDTO.getName());
        assertEquals(playList.getDescription(), playListDTO.getDescription());
        assertEquals(playList.getSongs().get(0).getTitle(), playListDTO.getSongs().get(0).getTitle());
    }

    @Test
    void testToEntity(){
        setup2();
        PlayListDTO playListDTO = new PlayListDTO(UUID.randomUUID(), "The moonlight", "google.com", theSongsDTO);
        PlayList playList = playListMapper.toEntity(playListDTO);
        assertEquals(playListDTO.getName(), playList.getName());
        assertEquals(playListDTO.getDescription(), playList.getDescription());
        assertEquals(playListDTO.getSongs().get(0).getTitle(), playList.getSongs().get(0).getTitle());
    }
}
