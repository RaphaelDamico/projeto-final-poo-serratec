package org.serratec.poo.academia;

import java.util.Scanner;

public interface Menu {
    void exibeMenu();
    void escolhaMenu(int opcao);
    void exibe();
    void buscaAgendamento();
    void buscaAvaliacao();
    void cadastra(int opcao);
    void remove();
}
