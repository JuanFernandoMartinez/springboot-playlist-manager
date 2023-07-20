package com.example.inventorymanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.inventorymanager.model.Song;

import java.util.UUID;


@Repository
public interface SongRepository extends JpaRepository<Song, UUID> {
}
