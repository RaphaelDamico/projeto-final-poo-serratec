package org.serratec.poo.utils;

import org.serratec.poo.classes.Aluno;
import org.serratec.poo.classes.Funcionario;
import org.serratec.poo.classes.PersonalTrainer;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static org.serratec.poo.classes.Login.chamaLogin;

public class ProcuraLista {
    public static int buscarCPF(String cpf, String senha, List <Aluno> alunos, List <PersonalTrainer> personais, List <Funcionario> funcionarios) throws IOException {

        int marcador = 0;
        boolean encontrado = false;
        
        for (Aluno aluno : alunos) {
            if (aluno.getCpf().contains(cpf) && aluno.getSenha().contains(senha)) {
                encontrado = true;
                marcador = 1;
                System.out.println("\nBem Vindo(a) "+aluno.getNome()+"\n");
                break;
                
            }
        }
        if (!encontrado) {
            for (PersonalTrainer personalTrainer : personais) {
                if (personalTrainer.getCpf().contains(cpf) && personalTrainer.getSenha().contains(senha)) {
                    encontrado = true;
                    marcador = 2;
                    System.out.println("\nBem Vindo(a) "+personalTrainer.getNome()+"\n");
                    break;
                }
            }
        }
        if (!encontrado) {
            for (Funcionario funcionario : funcionarios) {
                if (funcionario.getCpf().contains(cpf) && funcionario.getSenha().contains(senha)) {
                    encontrado = true;
                    marcador = 3;
                    System.out.println("\nBem Vindo(a) "+funcionario.getNome()+"\n");
                    break;
                }
            }
        }

        if (!encontrado) {
            System.out.println(String.format("""
                    USUARIO OU SENHA ERRADOS...
                    DESEJA BUSCAR UM NOVO CPF? (S/N)
                    """));
            marcador = -1;
            Scanner sc = new Scanner(System.in);
            String aux = sc.nextLine();
            if (aux.equalsIgnoreCase("s")){
                chamaLogin();
            }
            else{
                System.out.println(String.format("""
                    OBRIGADO POR UTILIZAR NOSSO SISTEMA...
                    """));
            }
        }
    return marcador;
    }
}
