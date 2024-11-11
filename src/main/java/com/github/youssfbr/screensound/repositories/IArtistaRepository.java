package com.github.youssfbr.screensound.repositories;

import com.github.youssfbr.screensound.models.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IArtistaRepository extends JpaRepository<Artista , Long> {
    Optional<Artista> findByNomeContainingIgnoreCase(String nomeArtista);
}
