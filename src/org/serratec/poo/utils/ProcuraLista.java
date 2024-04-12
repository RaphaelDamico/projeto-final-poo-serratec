package org.serratec.poo.utils;

import org.serratec.poo.classes.Aluno;
import org.serratec.poo.classes.Funcionario;
import org.serratec.poo.classes.PersonalTrainer;

import java.util.List;
import java.util.Scanner;

public class ProcuraLista {
    public static int buscarCPF(String cpf, List <Aluno> alunos, List <PersonalTrainer> personais, List <Funcionario> funcionarios) {

        int i = -1;
        int indice = 0;
        boolean encontrado = false;
        for (Aluno aluno : alunos) {
            i++;
            if (aluno.getCpf().contains(cpf)) {
                encontrado = true;
                indice = i;
                break;
            }
        }
        i = -1;
        for (PersonalTrainer personalTrainer : personais) {
            i++;
            if (personalTrainer.getCpf().contains(cpf)) {
                encontrado = true;
                indice = i;
                break;
            }
        }
        i = -1;
        for (Funcionario funcionario : funcionarios) {
            i++;
            if (funcionario.getCpf().contains(cpf)) {
                encontrado = true;
                indice = i;
                break;
            }
        }
        if (!encontrado) {
            indice = -1;
        }
    return indice;
    }
}
