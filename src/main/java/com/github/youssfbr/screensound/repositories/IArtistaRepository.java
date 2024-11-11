package com.github.youssfbr.screensound.repositories;

import com.github.youssfbr.screensound.models.Artista;
import com.github.youssfbr.screensound.models.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IArtistaRepository extends JpaRepository<Artista , Long> {

    Optional<Artista> findByNomeContainingIgnoreCase(String nomeArtista);

    @Query("""
            SELECT m FROM Artista a
            JOIN a.musicas m
            WHERE a.nome
            ILIKE %:nomeArtista%
            """)
    List<Musica> buscaMusicasPorArtista(String nomeArtista);
}
