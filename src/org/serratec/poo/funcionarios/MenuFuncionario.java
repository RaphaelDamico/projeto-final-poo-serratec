package org.serratec.poo.funcionarios;

import static org.serratec.poo.academia.PlanoMetodos.mostraPlanos;
import static org.serratec.poo.academia.PlanoMetodos.novoPlano;
import static org.serratec.poo.alunos.MetodosAluno.listaAluno;
import static org.serratec.poo.alunos.MetodosAluno.novoAluno;
import static org.serratec.poo.funcionarios.MetodosFuncionario.listaFuncionario;
import static org.serratec.poo.personaltrainers.MetodosPersonal.listaPersonal;
import static org.serratec.poo.personaltrainers.MetodosPersonal.novoPersonal;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.serratec.poo.academia.Menu;
import org.serratec.poo.academia.Pessoa;
import org.serratec.poo.alunos.Aluno;
import org.serratec.poo.personaltrainers.PersonalTrainer;

public class MenuFuncionario implements Menu {
    private Funcionario funcionario;

    public MenuFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    @Override
    public void exibeMenu() {
        System.out.printf("""
				1 - Cadastrar novo plano
				2 - Cadastrar novo aluno
				3 - Cadastrar novo Personal Trainer
				4 - Emitir relatório de planos
				5 - Emitir relatório de alunos
				6 - Emitir relatório de equipe
				7 - Emitir relação de avaliações físicas por período
				8 - Sair
				""");
    }

    @Override
    public void escolhaMenu(int opcao) {
        switch (opcao){
            case 1:
            	//Cadastrar novo plano
                cadastra(1);
                break;
            case 2:
            	//Cadastrar novo aluno
                cadastra(2);
                break;
            case 3:
            	//Cadastrar novo Personal Trainer
                cadastra(3);
                break;
            case 4:
            	//Emtir relatório de planos
                exibe(4);
                break;
            case 5:
            	// Emitir relatório de alunos
                exibe(5);
                break;
            case 6:
            	//Emitir relatório de equipe (funcionários e personal trainers)
                exibe(6);
                break;
            case 7:
            	//Emitir relação de avaliações físicas por período
            	
                break;
            case 8:
            	//Sair 
            	break;
            default:
                System.out.println("Digite uma opção válida...\n");
                break;
        }
    }

    @Override
    public void exibe(int opcao) {	
    	if(opcao == 4) {
    		mostraPlanos();
    	}
    	if(opcao == 5) {
    		List<Aluno> alunos = (listaAluno());
    		for (Aluno aluno : alunos) {
				System.out.println(aluno);
			}
    	}if(opcao == 6) {
    		List<Funcionario> listaFuncionarios = (listaFuncionario());
    		List<PersonalTrainer> listaPersonais = (listaPersonal());
    		List<Pessoa> listaCombinada = 
    				Stream.concat(listaFuncionario().stream(), listaPersonal().stream())
    				.collect(Collectors.toList());
    		System.out.println(listaCombinada);
    	}

    }

    @Override
    public void buscaAgendamento() {

    }

    @Override
    public void buscaAvaliacao() {

    }

    @Override
    public void cadastra(int opcao) {
    	if(opcao == 1) {
    		novoPlano();
    	}
    	if(opcao == 2) {
    		novoAluno();
    	}
    	if(opcao == 3) {
    		novoPersonal();
    	}
    }

    @Override
    public void remove() {

    }
}
