package org.serratec.poo.utils;

import org.serratec.poo.classes.Aluno;
import org.serratec.poo.classes.Funcionario;
import org.serratec.poo.classes.PersonalTrainer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.serratec.poo.classes.Login.chamaLogin;

public class ProcuraLista {
    public static int buscarCPF(String cpf, String senha, List <Aluno> alunos, List <PersonalTrainer> personais, List <Funcionario> funcionarios) throws IOException {

        int i = -1;
        int indice = 0;
        boolean encontrado = false;
        for (Aluno aluno : alunos) {
            i++;
            if (aluno.getCpf().contains(cpf) && aluno.getSenha().contains(senha)) {
                encontrado = true;
                indice = i;
                break;
            }
        }
        i = -1;
        for (PersonalTrainer personalTrainer : personais) {
            i++;
            if (personalTrainer.getCpf().contains(cpf) && personalTrainer.getSenha().contains(senha)) {
                encontrado = true;
                indice = i;
                int list = 1;
                break;
            }
        }
        i = -1;
        for (Funcionario funcionario : funcionarios) {
            i++;
            if (funcionario.getCpf().contains(cpf) && funcionario.getSenha().contains(senha)) {
                encontrado = true;
                //menuAluno();
                indice = i;
                break;
            }
        }
        if (!encontrado) {
            System.out.println(String.format("""
                    USUARIO OU SENHA ERRADOS...
                    DESEJA BUSCAR UM NOVO CPF? (S/N)
                    """));
            indice = -1;
            Scanner sc = new Scanner(System.in);
            String aux = sc.nextLine();
            if (aux.equalsIgnoreCase("s")){
                chamaLogin();
            }
            else{
                System.out.println(String.format("""
                    OBRIGADO POR UTILIZAR NOSSO SISTEMA...
                    """));
                return 0;
            }
        }
    return indice;
    }
}
