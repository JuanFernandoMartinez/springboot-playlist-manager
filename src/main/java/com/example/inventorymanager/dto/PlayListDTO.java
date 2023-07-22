package com.example.inventorymanager.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayListDTO {
    private UUID id;
    private String name;
    private String description;
    private List<SongDTO> songs;
}
