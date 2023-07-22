package com.example.inventorymanager.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.inventorymanager.model.Song;

import java.util.UUID;


@Repository
public interface SongRepository extends CrudRepository<Song, UUID> {
    Song getById(UUID id);
    Song getByTitle(String name);
}
