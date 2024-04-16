package org.serratec.poo.alunos;

import org.serratec.poo.academia.Agendamento;
import org.serratec.poo.academia.Menu;

import java.time.LocalDate;
import java.util.List;

import static java.awt.SystemColor.menu;
import static org.serratec.poo.academia.AgendamentoMetodos.novoAgendamento;
import static org.serratec.poo.principal.Programa.sc;

public class MenuAluno implements Menu {
    private Aluno aluno;

    public MenuAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Aluno getAluno() {
        return aluno;
    }

    @Override
    public void exibeMenu() {
        System.out.println("""
				1 - Visualizar dados e plano
				2 - Solicitar agendamento com o personal
				3 - Visualizar histórico de agendamentos
				4 - Cancelar agendamento
				5 - Visualizar avaliações físicas
				6 - Sair
				""");
    }

    @Override
    public void escolhaMenu(int opcao) {
        switch (opcao){
            case 1:
            	//Visualizar dados pessoais e plano contratado.
                exibe();
                break;
            case 2:
            	//Solicitar agendamento de horário com personal trainer.

                cadastra();
                break;
            case 3:
            	//Visualizar histórico de agendamentos.
                buscaAgendamento();
                break;
            case 4:
            	//Cancelar agendamento.

                remove();
                break;
            case 5:
            	//Visualizar avaliações físicas.
                buscaAgendamento();
                break;
            case 6:
                break;
            default:
                System.out.println("Digite uma opção válida...\n");
                break;
        }
    }

    @Override
    public void exibe(){
        System.out.println(getAluno());
    }
    @Override
    public void cadastra() {
        novoAgendamento();
    }
    @Override
    public void buscaAgendamento() {
    }
    public void remove(){
    }
    public void buscaAvaliacao() {
    }
}
