package com.github.youssfbr.screensound.principal;

import com.github.youssfbr.screensound.models.Artista;
import com.github.youssfbr.screensound.models.Musica;
import com.github.youssfbr.screensound.models.enums.TipoArtista;
import com.github.youssfbr.screensound.repositories.IArtistaRepository;
import com.github.youssfbr.screensound.utils.Mensagens;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;


@Service
public class Principal {

    private IArtistaRepository artistaRepository;
    private final Scanner sc = new Scanner(System.in);

    public Principal(IArtistaRepository artistaRepository) {
        this.artistaRepository = artistaRepository;
    }

    public void exibeMenu() {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println(Mensagens.MENSAGENS_OPCOES);
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 0 -> System.out.println("Encerrando a aplicação...");
                case 1 -> cadastrarArtistas();
                case 2 -> cadastrarMusicas();
                case 3 -> listarMusicas();
                case 4 -> buscarMusicasPorArtista();
                case 5 -> pesquisarDadosDoArtista();
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private void pesquisarDadosDoArtista() {
        System.out.println("Não implementado.");
    }

    private void buscarMusicasPorArtista() {
        System.out.println("Buscar músicas de que artista? ");
        final String nomeArtista = sc.nextLine();
        final List<Musica> musicas = artistaRepository.buscaMusicasPorArtista(nomeArtista);
        musicas.forEach(System.out::println);
    }

    private void listarMusicas() {
        final List<Artista> artistas = artistaRepository.findAll();
        artistas.forEach(System.out::println);
        artistas.forEach(a -> a.getMusicas().forEach(System.out::println));
    }

    private void cadastrarMusicas() {
        System.out.println("Cadastrar música de que artista? ");
        final String nomeArtista = sc.nextLine();
        Optional<Artista> artista = artistaRepository.findByNomeContainingIgnoreCase(nomeArtista);
        if (artista.isPresent()) {
            System.out.println("Informa o título da música: ");
            final String nomeMusica = sc.nextLine();
            final Musica musica = new Musica(nomeMusica);
            musica.setArtista(artista.get());
            artista.get().getMusicas().add(musica);
            artistaRepository.save(artista.get());
        } else {
            System.out.println("Artista não encontrado.");
        }
    }

    private void cadastrarArtistas() {
        String cadastrarNovoArtista = "S";

        while (cadastrarNovoArtista.equalsIgnoreCase("s")) {
            System.out.println("Informe o nome do Artista: ");
            final String nomeArtista = sc.nextLine();
            System.out.println("Informe o tipo do Artista: (solo, dupla ou banda)");
            final String tipo = sc.nextLine();
            final TipoArtista tipoArtista = TipoArtista.valueOf(tipo.toUpperCase());
            final Artista artista = new Artista(nomeArtista , tipoArtista);
            artistaRepository.save(artista);
            System.out.println("Cadastrar novo artista? (S/N) ");
            cadastrarNovoArtista = sc.nextLine();
        }

    }
}
