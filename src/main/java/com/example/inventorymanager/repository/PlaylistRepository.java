package com.example.inventorymanager.repository;

import com.example.inventorymanager.model.PlayList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlaylistRepository extends CrudRepository<PlayList,UUID> {
    PlayList getByName(String name);
    PlayList getById(UUID id);
}
