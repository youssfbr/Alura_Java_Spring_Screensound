package com.github.youssfbr.screensound.principal;

import com.github.youssfbr.screensound.utils.Mensagens;
import org.springframework.stereotype.Service;

import java.util.Scanner;


@Service
public class Principal {

    private final Scanner sc = new Scanner(System.in);

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
        System.out.println("Não implementado.");
    }

    private void listarMusicas() {
        System.out.println("Não implementado.");
    }

    private void cadastrarMusicas() {
        System.out.println("Não implementado.");
    }

    private void cadastrarArtistas() {
        System.out.println("Não implementado.");
    }
}
